package me.huynhducphu.spring.service;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.spring.dto.EmployeeCreateDto;
import me.huynhducphu.spring.dto.EmployeeUpdateDto;
import me.huynhducphu.spring.model.Department;
import me.huynhducphu.spring.model.Employee;
import me.huynhducphu.spring.repository.DepartmentRepository;
import me.huynhducphu.spring.repository.EmployeeRepository;
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
    private final DepartmentRepository departmentRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository
                .findById(id)
                .orElse(null);
    }

    public Employee createEmployee(EmployeeCreateDto dto) {
        Department dept = departmentRepository.findById(dto.getDepartmentId())
                .orElse(null);

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(dept);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeUpdateDto dto) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    if (dto.getName() != null) employee.setName(dto.getName());
                    if (dto.getAge() != null) employee.setAge(dto.getAge());
                    if (dto.getSalary() != null) employee.setSalary(dto.getSalary());
                    if (dto.getDepartmentId() != null) {
                        Department dept = departmentRepository.findById(dto.getDepartmentId())
                                .orElse(null);
                        employee.setDepartment(dept);
                    }
                    return employeeRepository.save(employee);
                })
                .orElse(null);
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeesWithSalaryAboveAverage() {
        return employeeRepository.findEmployeesWithSalaryAboveAverage();
    }


    public List<Employee> findByName(String name) {
        return employeeRepository.findEmployeeByNameContainingIgnoreCase(name);
    }

    public List<Employee> findByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }

    public List<Employee> findEmployeeBySalaryBetween(int min, int max) {
        return employeeRepository.findEmployeeBySalaryBetween(min, max);
    }

}
