package me.huynhducphu.bai1.repository;

import me.huynhducphu.bai1.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Admin 10/28/2025
 **/
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
