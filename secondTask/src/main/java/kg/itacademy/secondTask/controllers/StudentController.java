package kg.itacademy.secondTask.controllers;

import kg.itacademy.secondTask.entities.Student;
import kg.itacademy.secondTask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Student getById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/find/{fio}")
    public List<Student> getByFio(@PathVariable(value = "fio") @RequestHeader String fio) {
        return studentService.getByFio(fio);
    }
}
