package com.example.student_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
/*
@Getter
@Setter

 */
public class CreateStudentRequest {

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    private String name;


    @JsonProperty("email")
    @NotBlank(message= "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @JsonProperty("course")
    @NotBlank(message = "Course is Mandatory")
    private String course;
    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

     */
}
