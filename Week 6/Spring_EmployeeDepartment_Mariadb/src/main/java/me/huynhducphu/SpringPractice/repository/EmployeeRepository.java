package me.huynhducphu.SpringPractice.repository;

import me.huynhducphu.SpringPractice.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment_Id(String departmentId);

    List<Employee> findBySalary(double salary);

    List<Employee> findEmployeeByNameContainingIgnoreCase(String name);

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    List<Employee> findEmployeeBySalaryBetween(double salaryAfter, double salaryBefore);

}
