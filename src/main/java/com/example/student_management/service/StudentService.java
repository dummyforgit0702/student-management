package com.example.student_management.service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){
        this.repository= repository;
    }
    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student getStudentById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Student not found with id: "+ id));
    }
    public Student updateStudent(Long id, Student studentDetails){
        Student student= repository.findById(id).orElse(null);
        if(student!=null){
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setCourse(studentDetails.getCourse());
            return repository.save(student);
        }
        return null;
    }
    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
}
