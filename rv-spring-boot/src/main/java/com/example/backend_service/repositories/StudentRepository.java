package com.example.backend_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend_service.models.*;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findStudentByStudentID(Long studentID);

}
