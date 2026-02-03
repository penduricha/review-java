package com.example.backend_service.services;

import com.example.backend_service.models.Student;
import com.example.backend_service.repositories.StudentRepository;
import com.example.backend_service.services.i_services.I_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements I_StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) throws JpaSystemException {
        if(!getAllStudents().contains(student)) {
            studentRepository.save(student);
            return student;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws JpaSystemException {
        return studentRepository.findAll();
    }

    @Override
    public Long deleteStudent(Long studentID) throws JpaSystemException {
        Student studentFound = studentRepository.findStudentByStudentID(studentID);
        if(studentFound != null) {
            studentRepository.delete(studentFound);
            return studentFound.getStudentID();
        }
        return null;
    }

    @Override
    public Student updateStudentByStudentID(Long studentID, Student student) throws JpaSystemException {
        Student studentFound = studentRepository.findStudentByStudentID(studentID);
        if(studentFound != null) {
            if(student.getName() != null)
                studentFound.setName(student.getName());
            if(student.getDob() != null)
                studentFound.setDob(student.getDob());
            if(student.getGpa() != -1.0)
                studentFound.setGpa(student.getGpa());
            studentRepository.save(studentFound);
            return studentFound;
        }
        return null;
    }
}
