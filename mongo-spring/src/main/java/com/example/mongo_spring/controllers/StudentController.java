package com.example.mongo_spring.controllers;


import com.example.mongo_spring.models.Student;
import com.example.mongo_spring.services.StudentService;
import com.mongodb.MongoClientException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/student"})
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody Map<String, Object> studentToPost) throws MongoClientException, IllegalArgumentException, DateTimeException {
        Integer studentIDInt = (Integer)studentToPost.get("studentID");
        Long studentID = studentIDInt != null ? studentIDInt.longValue() : null;
        String name = (String)studentToPost.get("name");
        Double gpa = (Double)studentToPost.get("gpa");
        Map<String, Object> dob = (Map)studentToPost.get("dob");
        LocalDate dobLocalDate = null;
        if (dob != null) {
            Integer day = (Integer)dob.get("day");
            Integer month = (Integer)dob.get("month");
            Integer year = (Integer)dob.get("year");
            dobLocalDate = LocalDate.of(year, month, day);
        }

        Student studentToCreate = new Student(studentID, name, dobLocalDate, gpa);
        studentToCreate.setId((new ObjectId()).toString());
        Student studentCreated = this.studentService.createStudent(studentToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreated);
    }

    @GetMapping({"/students/all"})
    public ResponseEntity<List<Student>> getAllStudents() throws MongoClientException {
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }
}
