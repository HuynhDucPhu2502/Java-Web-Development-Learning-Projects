package me.huynhducphu.SpringPractice.repository;

import me.huynhducphu.SpringPractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    List<Employee> findEmployeeBySalaryBetween(double minSalary, double maxSalary);

    Employee findEmployeeByNameContainingIgnoreCase(String name);


}
