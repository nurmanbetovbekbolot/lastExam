package kg.itacademy.secondTask.services.impls;

import kg.itacademy.secondTask.entities.Course;
import kg.itacademy.secondTask.repositories.CourseRepository;
import kg.itacademy.secondTask.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        Optional<Course> optionalCustomer = courseRepository.findById(id);
        return optionalCustomer.orElse(new Course());
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }
}
