package com.example.student_management.service.impl;

import com.example.student_management.dto.CreateStudentRequest;
import com.example.student_management.dto.StudentResponse;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    public StudentServiceImpl(StudentRepository repository){
        this.repository= repository;
    }

    @Override
    public StudentResponse createStudent(CreateStudentRequest request){
        Student student= new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());

        return mapToResponse(repository.save(student));
    }

    @Override
    public StudentResponse getStudentById(Long id){
        Student student= repository.findById(id).orElseThrow(()->new EntityNotFoundException("Student not found with id: "+id));

        return mapToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, CreateStudentRequest request){
        Student student= repository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Student not found")
        );
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());

        return mapToResponse(repository.save(student));
    }

    @Override
    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
    private StudentResponse mapToResponse(Student student){
        StudentResponse response= new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setCourse(student.getCourse());

        return response;
    }
    @Override
    public List<StudentResponse> getAllStudents() {
        return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

}
