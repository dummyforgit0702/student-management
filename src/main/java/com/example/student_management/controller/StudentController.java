package com.example.student_management.controller;
import com.example.student_management.model.Student;
import com.example.student_management.repository.*;
import com.example.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@Tag(name="Student Controller", description = "CRUD operations for Student")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service= service;
    }

    @Operation(summary = "Add a new student")
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @Operation(summary="Get all students")
    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Update student by ID")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

}

