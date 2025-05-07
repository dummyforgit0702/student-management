package com.example.student_management.service;

import com.example.student_management.dto.CreateStudentRequest;
import com.example.student_management.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(CreateStudentRequest request);
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(Long id);
    StudentResponse updateStudent(Long id, CreateStudentRequest request);
    void deleteStudent(Long id);
}
