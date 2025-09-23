package me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository;

import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Admin 9/21/2025
 *
 **/
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByDepartment_Id(String departmentId);

    List<Employee> findBySalary(double salary);

    Optional<Employee> findFirstByOrderBySalaryDesc();

    Optional<Employee> findFirstByOrderByAgeDesc();


}
