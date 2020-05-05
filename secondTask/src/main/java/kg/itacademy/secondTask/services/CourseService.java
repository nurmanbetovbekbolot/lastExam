package kg.itacademy.secondTask.services;

import kg.itacademy.secondTask.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(Long id);
    void deleteById(Long id);
    void create(Course course);
}
