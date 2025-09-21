package me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository;

import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Admin 9/21/2025
 *
 **/
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
