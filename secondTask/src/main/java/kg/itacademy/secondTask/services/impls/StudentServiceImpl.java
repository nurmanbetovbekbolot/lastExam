package kg.itacademy.secondTask.services.impls;

import kg.itacademy.secondTask.entities.Student;
import kg.itacademy.secondTask.repositories.StudentRepository;
import kg.itacademy.secondTask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByFio(String fio) {
        return studentRepository.findAllByFio(fio);
    }

    @Override
    public Student getById(Long id) {
        Optional<Student> optionalCustomer = studentRepository.findById(id);
        return optionalCustomer.orElse(new Student());
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }
}
