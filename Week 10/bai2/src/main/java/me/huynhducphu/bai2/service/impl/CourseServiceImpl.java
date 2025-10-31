package me.huynhducphu.bai2.service.impl;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.bai2.model.Course;
import me.huynhducphu.bai2.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Admin 10/31/2025
 **/
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements me.huynhducphu.bai2.service.CourseService {

    private final CourseRepository courseRepository;

    // upsert = update + insert
    @Override
    public void upsert(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public void openCourse(Long id) {
        Course course = courseRepository
                .findById(id)
                .orElse(null);

        if (course != null) {
            course.setIsOpen(true);
            courseRepository.save(course);
        }

    }


}
