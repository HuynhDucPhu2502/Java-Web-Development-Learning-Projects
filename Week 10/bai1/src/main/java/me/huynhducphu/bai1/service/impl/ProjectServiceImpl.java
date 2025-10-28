package me.huynhducphu.bai1.service.impl;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.bai1.model.Project;
import me.huynhducphu.bai1.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Admin 10/28/2025
 **/
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements me.huynhducphu.bai1.service.ProjectService {

    private final ProjectRepository projectRepository;

    // upsert = insert + update
    @Override
    public void upsert(Project project) {
        projectRepository.save(project);
    }

    // delete
    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository
                .findById(id)
                .orElse(null);
    }


}
