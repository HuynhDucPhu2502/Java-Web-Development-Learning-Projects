package me.huynhducphu.spring.repository;

import me.huynhducphu.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Admin 9/16/2025
 *
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findEmployeeByNameContainingIgnoreCase(String name);

    List<Employee> findEmployeeBySalaryBetween(double salaryAfter, double salaryBefore);

    List<Employee> findByAge(int age);

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)")
    List<Employee> findEmployeesWithSalaryAboveAverage();

}
