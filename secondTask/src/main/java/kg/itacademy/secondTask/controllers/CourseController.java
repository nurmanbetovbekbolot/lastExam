package kg.itacademy.secondTask.controllers;

import kg.itacademy.secondTask.entities.Course;
import kg.itacademy.secondTask.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Course getById(@PathVariable("id")Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody Course course) {
        courseService.create(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        courseService.deleteById(id);
    }
}
