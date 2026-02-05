package com.example.mongo_spring.repositories;


import java.util.List;

import com.example.mongo_spring.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByGpaGreaterThanEqual(double gpa);

    @Query("{ 'gpa' : { $gte: ?0 } }")
    List<Student> getStudentsHighAchieversByMinGpa(double minGpa);
}