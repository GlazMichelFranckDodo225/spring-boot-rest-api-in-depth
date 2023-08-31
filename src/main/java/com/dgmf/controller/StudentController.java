package com.dgmf.controller;

import com.dgmf.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student") // http://localhost:8080/student
    public StudentDTO getStudent() {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        return studentDTO;
    }
}
