package me.huynhducphu.spring.repository;

import me.huynhducphu.spring.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Admin 9/21/2025
 *
 **/
public interface DepartmentRepository extends MongoRepository<Department, String> {

    
}
