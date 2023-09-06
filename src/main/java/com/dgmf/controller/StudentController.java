package com.dgmf.controller;

import com.dgmf.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/students") // http://localhost:8080/students
    public List<StudentDTO> getStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        studentDTOS.add(new StudentDTO(2L, "Alex", "Gomez"));
        studentDTOS.add(new StudentDTO(3L, "Guy", "Stewart"));
        studentDTOS.add(new StudentDTO(4L, "Francis", "Pedro"));
        studentDTOS.add(new StudentDTO(5L, "Nolan", "Howard"));
        studentDTOS.add(new StudentDTO(6L, "Edmond", "Lopez"));

        return studentDTOS;
    }
}
