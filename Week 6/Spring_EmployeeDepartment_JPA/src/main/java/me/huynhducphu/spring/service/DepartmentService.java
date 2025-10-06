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

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department newDept) {
        return departmentRepository.findById(id)
                .map(d -> {
                    d.setName(newDept.getName());
                    return departmentRepository.save(d);
                })
                .orElse(null);
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
