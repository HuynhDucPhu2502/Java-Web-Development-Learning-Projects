package me.huynhducphu.bai1.service;

import me.huynhducphu.bai1.model.Project;

import java.util.List;

/**
 * Admin 10/28/2025
 **/
public interface ProjectService {
    // upsert = insert + update
    void upsert(Project project);

    // delete
    void delete(Long id);

    List<Project> findAll();

    Project findById(Long id);
}
