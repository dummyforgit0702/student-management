package com.example.student_management.service;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class StudentServiceTest {
    private StudentRepository repository;
    private StudentServiceImpl service;

    @BeforeEach
    void setUp(){
        repository= mock(StudentRepository.class);
        service= new StudentServiceImpl(repository);
    }

    @Test
    void testSaveStudent(){
        Student student= new Student("Alice", "alice@example.com", "Math");
        when(repository.save(student)).thenReturn(student);


        Student saved= service.saveStudent(student);
        assertEquals("Alice", saved.getName());
    }

    @Test
    void testGetAllStudents(){
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Student("Alice", "alice@example.com", "Math"),
                new Student("Bob", "bob@example.com", "Physics")
        ));
        List<Student> students= service.getAllStudents();
        assertEquals(2, students.size());
    }

    @Test
    void testGetStudentById(){
        Student student= new Student("Alice", "alice@example.com", "Math");
        when(repository.findById(1L)).thenReturn(Optional.of(student));

        Student result= service.getStudentById(1L);
        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }

    @Test
    void testDeleteStudent(){
        doNothing().when(repository).deleteById(1L);
        service.deleteStudent(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
