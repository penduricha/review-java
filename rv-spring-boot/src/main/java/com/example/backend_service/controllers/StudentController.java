package com.example.backend_service.controllers;

import com.example.backend_service.models.Student;
import com.example.backend_service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody Map<String, Object> studentToPost) throws JpaSystemException {
        /*
            JSON post:
            {
                name: "Nguyen Van A",
                dob: { day: 10, month: 12, year: 1990 }
                gpa: 3.2
            }
         */
//        Integer studentIDInt = (Integer) studentToPost.get("studentID");
//        Long studentID = studentIDInt != null ? studentIDInt.longValue() : null;
//        public Student(String name, LocalDate dob, double gpa)
        String name = (String) studentToPost.get("name");
        Double gpa = (Double) studentToPost.get("gpa");
        Map<String, Object> dob = (Map<String, Object>) studentToPost.get("dob");
        LocalDate dobLocalDate = null;
        if(dob != null) {
            Integer day = (Integer) dob.get("day");
            Integer month = (Integer) dob.get("month");
            Integer year = (Integer) dob.get("year");
            dobLocalDate = Optional.ofNullable(year)
                    .flatMap(y -> Optional.ofNullable(month)
                            .flatMap(m -> Optional.ofNullable(day)
                                    .map(d -> LocalDate.of(y, m, d))))
                    .orElse(null);
        }
//         = LocalDate.of(year, month, day);
        Student studentToCreate =new Student(name, dobLocalDate, gpa);
        Student studentCreated = studentService.createStudent(studentToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreated);
    }

    @GetMapping("/students/all")
    public ResponseEntity<List<Student>> getAllStudents() throws JpaSystemException {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestParam Long studentID) throws JpaSystemException {
        return ResponseEntity.ok(studentService.deleteStudent(studentID));
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestParam Long studentID,
    @RequestBody Map<String, Object> studentToPut) throws JpaSystemException {
        String name = (String) studentToPut.get("name");
        Double gpa = (Double) studentToPut.get("gpa");
        Map<String, Object> dob = (Map<String, Object>) studentToPut.get("dob");
        LocalDate dobLocalDate = null;
        if(dob != null) {
            Integer day = (Integer) dob.get("day");
            Integer month = (Integer) dob.get("month");
            Integer year = (Integer) dob.get("year");
            dobLocalDate = Optional.ofNullable(year)
                    .flatMap(y -> Optional.ofNullable(month)
                            .flatMap(m -> Optional.ofNullable(day)
                                    .map(d -> LocalDate.of(y, m, d))))
                    .orElse(null);
        }
        if(gpa == null)
            gpa = -1.0;
        Student studentToUpdate =new Student(name, dobLocalDate, gpa);
        return ResponseEntity.ok(studentService.updateStudentByStudentID(studentID, studentToUpdate));
    }
}
