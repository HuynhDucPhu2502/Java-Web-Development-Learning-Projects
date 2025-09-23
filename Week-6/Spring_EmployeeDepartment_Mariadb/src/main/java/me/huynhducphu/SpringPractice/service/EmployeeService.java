package me.huynhducphu.SpringPractice.service;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.SpringPractice.model.Employee;
import me.huynhducphu.SpringPractice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findEmployeeByNameContainingIgnoreCase(name);
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }

    public List<Employee> findEmployeeBySalaryBetween(int min, int max) {
        return employeeRepository.findEmployeeBySalaryBetween(min, max);
    }

}
