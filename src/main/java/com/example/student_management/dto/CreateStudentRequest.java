package com.example.student_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateStudentRequest {

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")  // ← Prevents null and blank ("")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")  // ← Validates format
    private String email;

    @JsonProperty("course")
    @NotBlank(message = "Course is mandatory")
    private String course;
}
