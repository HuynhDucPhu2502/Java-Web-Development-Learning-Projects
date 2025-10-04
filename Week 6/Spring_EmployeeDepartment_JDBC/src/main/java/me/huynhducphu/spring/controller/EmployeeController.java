package me.huynhducphu.spring.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.EmployeeCreateDto;
import me.huynhducphu.spring.dto.EmployeeUpdateDto;
import me.huynhducphu.spring.model.Employee;
import me.huynhducphu.spring.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 10/4/2025
 *
 **/
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee e = employeeService.findById(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeCreateDto dto) {
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody EmployeeUpdateDto dto) {
        Employee e = employeeService.updateEmployee(id, dto);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Employee>> findByAge(@PathVariable int age) {
        return ResponseEntity.ok(employeeService.findByAge(age));
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findByDepartmentId(id));
    }

    @GetMapping("/salary-between/{min}/{max}")
    public ResponseEntity<List<Employee>> findBySalaryRange(@PathVariable double min,
                                                            @PathVariable double max) {
        return ResponseEntity.ok(employeeService.findEmployeeBySalaryBetween(min, max));
    }
}
