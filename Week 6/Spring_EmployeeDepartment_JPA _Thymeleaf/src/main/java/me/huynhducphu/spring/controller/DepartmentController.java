package me.huynhducphu.spring.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.model.Department;
import me.huynhducphu.spring.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 10/6/2025
 *
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "department-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("isEdit", false);
        return "department-form";
    }

    @PostMapping
    public String createDepartment(@ModelAttribute("department") Department department) {
        departmentService.create(department);
        return "redirect:/departments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Department department = departmentService.findById(id);
        if (department == null) return "redirect:/departments";
        model.addAttribute("department", department);
        model.addAttribute("isEdit", true);
        return "department-form";
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id,
                                   @ModelAttribute("department") Department department) {
        departmentService.update(id, department);
        return "redirect:/departments";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/departments";
    }
}
