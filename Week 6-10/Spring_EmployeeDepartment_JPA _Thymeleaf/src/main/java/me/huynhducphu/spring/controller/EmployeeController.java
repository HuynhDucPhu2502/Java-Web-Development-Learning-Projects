package me.huynhducphu.spring.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.EmployeeCreateDto;
import me.huynhducphu.spring.dto.EmployeeUpdateDto;
import me.huynhducphu.spring.model.Employee;
import me.huynhducphu.spring.service.EmployeeService;
import me.huynhducphu.spring.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentRepository departmentRepository;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("departments", departmentRepository.findAll());
        return "employee-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeCreateDto());
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("isEdit", false);
        return "employee-form";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employeeDto") EmployeeCreateDto dto) {
        employeeService.createEmployee(dto);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) return "redirect:/employees";

        EmployeeUpdateDto dto = new EmployeeUpdateDto();
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setSalary(employee.getSalary());
        if (employee.getDepartment() != null)
            dto.setDepartmentId(employee.getDepartment().getId());

        model.addAttribute("employeeId", id);
        model.addAttribute("employeeDto", dto);
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("isEdit", true);
        return "employee-form";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @ModelAttribute("employeeDto") EmployeeUpdateDto dto) {
        employeeService.updateEmployee(id, dto);
        return "redirect:/employees";
    }

    // 🔍 Route tìm kiếm nâng cao
    @GetMapping("/search")
    public String searchEmployees(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) Double minSalary,
                                  @RequestParam(required = false) Double maxSalary,
                                  @RequestParam(required = false) Long deptId,
                                  Model model) {

        List<Employee> results = employeeService.advancedSearch(name, age, minSalary, maxSalary, deptId);
        model.addAttribute("employees", results);
        model.addAttribute("departments", departmentRepository.findAll());
        return "employee-list";
    }
}