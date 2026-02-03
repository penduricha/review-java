package com.example.backend_service.services.i_services;

import com.example.backend_service.models.Student;

import java.util.List;

public interface I_StudentService {
    public Student createStudent(Student student);

    public List<Student> getAllStudents();

    public Long deleteStudent(Long studentID);

    public Student updateStudentByStudentID(Long studentID, Student student);
}
