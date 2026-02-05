package com.example.mongo_spring.services.i_services;


import com.example.mongo_spring.models.Student;

import java.util.List;

public interface I_StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentsWithGpaGreaterThan(double minGpa);

    Long deleteStudentByStudentID(Long studentID);

    Student updateStudentByStudentID(Long studentID, Student student);
}
