package me.huynhducphu.spring.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.request.DepartmentRequest;
import me.huynhducphu.spring.dto.response.DepartmentResponse;
import me.huynhducphu.spring.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentResponse create(@RequestBody DepartmentRequest request) {
        return departmentService.createDepartment(request);
    }

    @GetMapping
    public List<DepartmentResponse> getAll() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponse update(@PathVariable String id, @RequestBody DepartmentRequest request) {
        return departmentService.updateDepartment(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }

}
