package me.huynhducphu.Spring_EmployeeDepartment_Mongo.service.impl;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.request.DepartmentRequest;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.response.DepartmentResponse;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Department;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.DepartmentRepository;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements me.huynhducphu.Spring_EmployeeDepartment_Mongo.service.DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    // CREATE
    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getName())
                .build();
        Department saved = departmentRepository.save(department);
        return new DepartmentResponse(saved.getId(), saved.getName());
    }

    // READ ALL
    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentResponse(d.getId(), d.getName()))
                .toList();
    }

    // READ by ID
    @Override
    public DepartmentResponse getDepartmentById(String id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return new DepartmentResponse(department.getId(), department.getName());
    }

    // UPDATE
    @Override
    public DepartmentResponse updateDepartment(String id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(request.getName());
        Department updated = departmentRepository.save(department);
        return new DepartmentResponse(updated.getId(), updated.getName());
    }

    // DELETE
    @Override
    public void deleteDepartment(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }

        employeeRepository.findByDepartment_Id(id)
                .forEach(emp -> {
                    emp.setDepartment(null);
                    employeeRepository.save(emp);
                });

        departmentRepository.deleteById(id);
    }

}
