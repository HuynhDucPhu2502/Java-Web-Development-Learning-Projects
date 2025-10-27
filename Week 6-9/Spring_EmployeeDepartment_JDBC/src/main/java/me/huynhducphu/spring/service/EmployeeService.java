package me.huynhducphu.spring.service;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.EmployeeCreateDto;
import me.huynhducphu.spring.dto.EmployeeUpdateDto;
import me.huynhducphu.spring.model.Department;
import me.huynhducphu.spring.model.Employee;
import me.huynhducphu.spring.repository.DepartmentJdbcRepository;
import me.huynhducphu.spring.repository.EmployeeJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Admin 10/4/2025
 *
 **/
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeJdbcRepository employeeRepository;
    private final DepartmentJdbcRepository departmentRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(EmployeeCreateDto dto) {
        Department dept = departmentRepository.findById(dto.getDepartmentId()).orElse(null);

        Employee e = new Employee();
        e.setName(dto.getName());
        e.setAge(dto.getAge());
        e.setSalary(dto.getSalary());
        e.setDepartment(dept);

        employeeRepository.save(e);
        return e;
    }

    public Employee updateEmployee(Long id, EmployeeUpdateDto dto) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing == null) return null;

        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getAge() != null) existing.setAge(dto.getAge());
        if (dto.getSalary() != null) existing.setSalary(dto.getSalary());
        if (dto.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(dto.getDepartmentId()).orElse(null);
            existing.setDepartment(dept);
        }

        employeeRepository.update(existing);
        return existing;
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    public List<Employee> findEmployeeBySalaryBetween(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }
}