package com.dgmf.controller;

import com.dgmf.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // {id} ==> URI Template Variable
    // http://localhost:8080/students/7/Howard/Hugues
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public StudentDTO studentPathVariable(
            @PathVariable("id") Long studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
    ) {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    // Rest API with Request Params
    // http://localhost:8080/students/query?id=1&firstname=Franck&lastname=Dodo
    @GetMapping("/students/query")
    public StudentDTO studentRequestVariable(
            @RequestParam("id") Long studentId,
            @RequestParam("firstname") String studentFirstName,
            @RequestParam("lastname") String studentLastName
    ) {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    // Rest API that handles HTTP Post Request
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = StudentDTO.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();

        return student;
    }

}
