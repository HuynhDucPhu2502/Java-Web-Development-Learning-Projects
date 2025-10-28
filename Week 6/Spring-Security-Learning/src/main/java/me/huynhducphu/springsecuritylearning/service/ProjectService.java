package me.huynhducphu.springsecuritylearning.service;

import me.huynhducphu.springsecuritylearning.model.Project;

import java.util.List;

/**
 * Admin 10/27/2025
 **/
public interface ProjectService {
    // upsert = insert + update
    void upsert(Project project, Long id);

    void delete(Long id);

    List<Project> findAll();

    Project findById(Long id);
}
