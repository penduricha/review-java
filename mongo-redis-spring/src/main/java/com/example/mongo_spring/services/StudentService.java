package com.example.mongo_spring.services;


import com.example.mongo_spring.models.Student;
import com.example.mongo_spring.repositories.StudentRepository;
import com.example.mongo_spring.services.i_services.I_StudentService;
import com.mongodb.MongoClientException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements I_StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String STUDENT_IDS_SET = "student:all_student_ids";

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) throws MongoClientException, RedisSystemException {
        Long studentID = student.getStudentID();
        // 1. Kiểm tra nhanh trong Redis Set (Tốc độ O(1) - cực nhanh)
        Student savedStudent = null;
        if (studentID != null) {
            Boolean isExisted = redisTemplate.opsForSet().isMember(STUDENT_IDS_SET, studentID);
            Student foundStudentByStudentID = studentRepository.findByStudentID(studentID);
            //double check
            if (Boolean.TRUE.equals(isExisted) || foundStudentByStudentID !=null) {
                // Đã tồn tại trong danh sách ID của Redis
                return savedStudent;
            }
            redisTemplate.opsForSet().add(STUDENT_IDS_SET, studentID);
            savedStudent = studentRepository.save(student);
        }
        return savedStudent;
    }
    //return this.studentRepository.existsById(student.getId()) && student.getId() != null ? null : (Student)this.studentRepository.save(student);

    public List<Student> getAllStudents() throws MongoClientException {
        return this.studentRepository.findAll();
    }

    public List<Student> getStudentsWithGpaGreaterThan(double minGpa) throws MongoClientException {
        return this.studentRepository.getStudentsHighAchieversByMinGpa(minGpa);
    }

    public Long deleteStudentByStudentID(Long studentID) throws MongoClientException, RedisSystemException {
//        Student studentFound = studentRepository.findByStudentID(studentID);
//        if(studentFound != null) {
//            studentRepository.delete(studentFound);
//            return studentFound.getStudentID();
//        }
//        throw new RuntimeException("Student with ID " + studentID + " not found");
        Boolean isExisted = redisTemplate.opsForSet().isMember(STUDENT_IDS_SET, studentID);
        if (Boolean.TRUE.equals(isExisted)) {
            Student studentFound = studentRepository.findByStudentID(studentID);
            redisTemplate.opsForSet().remove(STUDENT_IDS_SET, studentID);
            studentRepository.delete(studentFound);
            return studentFound.getStudentID();
        }
        throw new RuntimeException("Student with ID " + studentID + " not found");
    }

    public Student updateStudentByStudentID(Long studentID, Student student) throws MongoClientException {
        Student studentFound = studentRepository.findByStudentID(studentID);
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
        throw new RuntimeException("Student with ID " + studentID + " not found");
    }
}
