package kg.itacademy.secondTask.repositories;

import kg.itacademy.secondTask.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s.* from student s" +
            " where s.fio= :fio", nativeQuery = true)
    List<Student> findAllByFio(@Param("fio") String fio);

}
