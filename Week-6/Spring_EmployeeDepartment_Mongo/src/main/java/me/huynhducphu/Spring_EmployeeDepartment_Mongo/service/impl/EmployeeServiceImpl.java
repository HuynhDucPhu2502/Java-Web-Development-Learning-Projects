package me.huynhducphu.Spring_EmployeeDepartment_Mongo.service.impl;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.request.EmployeeRequest;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.dto.response.EmployeeResponse;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Department;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Employee;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.DepartmentRepository;
import me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements me.huynhducphu.Spring_EmployeeDepartment_Mongo.service.EmployeeService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    // CREATE
    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setSalary(request.getSalary());
        emp.setDepartment(dept);

        Employee saved = employeeRepository.save(emp);

        return mapToResponse(saved);
    }

    // READ ALL
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // READ by ID
    @Override
    public EmployeeResponse getEmployeeById(String id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToResponse(emp);
    }

    // UPDATE
    @Override
    public EmployeeResponse updateEmployee(String id, EmployeeRequest request) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(request.getName());
        emp.setSalary(request.getSalary());

        if (request.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            emp.setDepartment(dept);
        } else {
            emp.setDepartment(null);
        }

        Employee updated = employeeRepository.save(emp);
        return mapToResponse(updated);
    }

    // DELETE
    @Override
    public void deleteEmployee(String id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeResponse> getHighestSalaryOrAge() {
        List<EmployeeResponse> result = new ArrayList<>();

        employeeRepository.findFirstByOrderBySalaryDesc()
                .map(this::mapToResponse)
                .ifPresent(result::add);

        employeeRepository.findFirstByOrderByAgeDesc()
                .map(this::mapToResponse)
                .ifPresent(result::add);

        return result.stream()
                .distinct()
                .toList();
    }

    // helper method
    private EmployeeResponse mapToResponse(Employee emp) {
        return new EmployeeResponse(
                emp.getId(),
                emp.getName(),
                emp.getSalary(),
                emp.getDepartment() != null ? emp.getDepartment().getName() : null,
                emp.getDepartment() != null ? emp.getDepartment().getId() : null,
                emp.getAge()
        );
    }


}
