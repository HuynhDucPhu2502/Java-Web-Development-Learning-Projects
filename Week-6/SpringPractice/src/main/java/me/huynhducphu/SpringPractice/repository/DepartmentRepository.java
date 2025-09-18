package me.huynhducphu.SpringPractice.repository;

import me.huynhducphu.SpringPractice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Admin 9/16/2025
 *
 **/
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
