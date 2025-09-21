package me.huynhducphu.Spring_EmployeeDepartment_Mongo.repository;

import me.huynhducphu.Spring_EmployeeDepartment_Mongo.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Admin 9/21/2025
 *
 **/
public interface DepartmentRepository extends MongoRepository<Department, String> {


}
