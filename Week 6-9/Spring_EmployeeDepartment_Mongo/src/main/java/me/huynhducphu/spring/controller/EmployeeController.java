package me.huynhducphu.spring.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.request.EmployeeRequest;
import me.huynhducphu.spring.dto.response.EmployeeResponse;
import me.huynhducphu.spring.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/max-salary")
    public List<EmployeeResponse> getHighestSalary() {
        return employeeService.getHighestSalaryOrAge();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable String id,
                                   @RequestBody EmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }

}
