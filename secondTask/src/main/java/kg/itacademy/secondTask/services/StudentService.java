package kg.itacademy.secondTask.services;

import kg.itacademy.secondTask.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    List<Student> getByFio(String fio);
    Student getById(Long id);
    void deleteById(Long id);
    void create(Student student);
}
