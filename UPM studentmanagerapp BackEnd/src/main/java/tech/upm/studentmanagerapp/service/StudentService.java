package tech.upm.studentmanagerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.upm.studentmanagerapp.exception.UserNotFoundException;
import tech.upm.studentmanagerapp.model.Student;
import tech.upm.studentmanagerapp.repo.StudentRepo;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studnetRepo;
    @Autowired
    public StudentService(StudentRepo studnetRepo) {
        this.studnetRepo = studnetRepo;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studnetRepo.save(student);
    }
    public List<Student> findAllStudents(){
        return studnetRepo.findAll();
    }
    public Student updateStudent(Student student){
        return studnetRepo.save(student);
    }
    public Student findStudentBYiId(Long id){
        return studnetRepo.findStudentById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+"was not found"));
    }
    @Transactional
    public void deleteStudent(Long id){
        studnetRepo.deleteStudentById(id);
    }

}
