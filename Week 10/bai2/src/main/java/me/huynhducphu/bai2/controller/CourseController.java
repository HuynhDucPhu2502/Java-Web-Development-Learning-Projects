package me.huynhducphu.bai2.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.bai2.model.Course;
import me.huynhducphu.bai2.service.CourseService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

/**
 * Admin 10/31/2025
 **/
@Controller
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public String showCourseListPage(
            Model model,
            Authentication authentication
    ) {

        String userName = authentication.getName();
        String roleName = authentication
                .getAuthorities()
                .stream()
                .map(x -> x.getAuthority())
                .collect(Collectors.joining(","));

        model.addAttribute("name", userName);
        model.addAttribute("roleName", roleName);
        model.addAttribute("courses", courseService.findAll());


        return "course-list";
    }

    // courses/form =>  new
    // courses/form?id=X => update course co id  la X
    @GetMapping("/courses/form")
    public String showCourseForm(
            Model model,
            @RequestParam(required = false) Long id
    ) {
        if (id != null) {
            Course course = courseService.findById(id);

            if (course != null)
                model.addAttribute("course", course);
            else
                model.addAttribute("course", new Course());


        } else model.addAttribute("course", new Course());


        return "course-form";
    }

    @PostMapping("/courses")
    public String upsertCourse(Course course) {
        courseService.upsert(course);
        return "redirect:/courses";
    }

    @PostMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/courses";
    }

    @PostMapping("/courses/open/{id}")
    public String openCourse(@PathVariable Long id) {
        courseService.openCourse(id);
        return "redirect:/courses";
    }


}
