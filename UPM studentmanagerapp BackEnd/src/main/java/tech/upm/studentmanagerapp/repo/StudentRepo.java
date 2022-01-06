package tech.upm.studentmanagerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.upm.studentmanagerapp.model.Student;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
    void deleteStudentById(Long id);

    Optional <Student> findStudentById(Long id);
}
