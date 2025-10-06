package me.huynhducphu.spring.service;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.model.Department;
import me.huynhducphu.spring.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Admin 10/6/2025
 *
 **/
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long id, Department department) {
        return departmentRepository.findById(id)
                .map(existing -> {
                    existing.setName(department.getName());
                    return departmentRepository.save(existing);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}