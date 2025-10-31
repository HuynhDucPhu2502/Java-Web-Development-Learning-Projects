package me.huynhducphu.bai2.repository;

import me.huynhducphu.bai2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Admin 10/31/2025
 **/
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
