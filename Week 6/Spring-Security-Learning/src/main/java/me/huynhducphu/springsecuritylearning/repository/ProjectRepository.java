package me.huynhducphu.springsecuritylearning.repository;

import me.huynhducphu.springsecuritylearning.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Admin 10/27/2025
 **/
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
