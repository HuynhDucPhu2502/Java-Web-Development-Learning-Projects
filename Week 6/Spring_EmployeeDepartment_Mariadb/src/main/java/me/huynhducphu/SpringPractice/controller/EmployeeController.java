package me.huynhducphu.SpringPractice.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.SpringPractice.model.Employee;
import me.huynhducphu.SpringPractice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findByEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findByDepartmentId(id));
    }

    @GetMapping("/salary-between/{min}/{max}")
    public ResponseEntity<List<Employee>> findEmployeeBySalaryBetween(@PathVariable int min, @PathVariable int max) {
        return ResponseEntity.ok(employeeService.findEmployeeBySalaryBetween(min, max));
    }


}
