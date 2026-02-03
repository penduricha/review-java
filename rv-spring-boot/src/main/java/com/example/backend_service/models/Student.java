package com.example.backend_service.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;

    @Column(nullable = false, columnDefinition = "nvarchar(50)")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false, columnDefinition = "date")
    private LocalDate dob;

    @Column(nullable = false)
    private double gpa;

    public Student(String name, LocalDate dob, double gpa) {
        this.name = name;
        this.dob = dob;
        this.gpa = gpa;
    }
}
