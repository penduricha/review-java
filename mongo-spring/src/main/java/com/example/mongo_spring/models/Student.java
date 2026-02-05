package com.example.mongo_spring.models;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(
        collection = "students"
)
public class Student implements Serializable {
    @Id
    private String id;
    @Indexed(
            unique = true
    )
    @Field("student_id")
    private Long studentID;
    private String name;
    private LocalDate dob;
    private double gpa;

    public Student(Long studentID, String name, LocalDate dob, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.dob = dob;
        this.gpa = gpa;
    }

    @Generated
    public void setId(final String id) {
        this.id = id;
    }

    @Generated
    public void setStudentID(final Long studentID) {
        this.studentID = studentID;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setDob(final LocalDate dob) {
        this.dob = dob;
    }

    @Generated
    public void setGpa(final double gpa) {
        this.gpa = gpa;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public Long getStudentID() {
        return this.studentID;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public LocalDate getDob() {
        return this.dob;
    }

    @Generated
    public double getGpa() {
        return this.gpa;
    }

    @Generated
    public String toString() {
        String var10000 = this.getId();
        return "Student(id=" + var10000 + ", studentID=" + this.getStudentID() + ", name=" + this.getName() + ", dob=" + String.valueOf(this.getDob()) + ", gpa=" + this.getGpa() + ")";
    }

    @Generated
    public Student() {
    }

    @Generated
    public Student(final String id, final Long studentID, final String name, final LocalDate dob, final double gpa) {
        this.id = id;
        this.studentID = studentID;
        this.name = name;
        this.dob = dob;
        this.gpa = gpa;
    }
}

