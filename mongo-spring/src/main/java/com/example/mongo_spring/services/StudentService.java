package com.example.mongo_spring.services;


import com.example.mongo_spring.models.Student;
import com.example.mongo_spring.repositories.StudentRepository;
import com.example.mongo_spring.services.i_services.I_StudentService;
import com.mongodb.MongoClientException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements I_StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) throws MongoClientException {
        return this.studentRepository.existsById(student.getId()) && student.getId() != null ? null : (Student)this.studentRepository.save(student);
    }

    public List<Student> getAllStudents() throws MongoClientException {
        return this.studentRepository.findAll();
    }

    public List<Student> getStudentsWithGpaGreaterThan(double minGpa) throws MongoClientException {
        return this.studentRepository.getStudentsHighAchieversByMinGpa(minGpa);
    }

    public Long deleteStudentByStudentID(Long studentID) throws MongoClientException {
        return 0L;
    }

    public Student updateStudentByStudentID(Long studentID, Student student) throws MongoClientException {
        return null;
    }
}
