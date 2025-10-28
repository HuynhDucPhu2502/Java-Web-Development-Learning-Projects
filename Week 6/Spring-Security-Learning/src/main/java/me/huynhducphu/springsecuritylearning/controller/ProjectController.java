package me.huynhducphu.springsecuritylearning.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.springsecuritylearning.model.Project;
import me.huynhducphu.springsecuritylearning.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Admin 10/27/2025
 **/
@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects/form")
    public String showSavePage(
            Model model,
            @RequestParam(required = false) Long id
    ) {
        if (id != null) {
            var project = projectService.findById(id);
            if (project != null)
                model.addAttribute("project", project);
            else model.addAttribute("project", new Project());
        } else model.addAttribute("project", new Project());

        return "form-page";
    }

    @PostMapping("/projects")
    public String saveProject(@ModelAttribute Project project) {
        projectService.upsert(project, null);
        return "redirect:/home";
    }

    @PostMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/home";
    }


}
