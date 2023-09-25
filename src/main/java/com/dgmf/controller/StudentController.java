package com.dgmf.controller;

import com.dgmf.dto.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student") // http://localhost:8080/student
    public Student getStudent() {
        Student studentDTO = Student.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        return studentDTO;
    }

    @GetMapping("/students") // http://localhost:8080/students
    public List<Student> getStudents() {
        List<Student> studentDTOS = new ArrayList<>();
        studentDTOS.add(new Student(2L, "Alex", "Gomez"));
        studentDTOS.add(new Student(3L, "Guy", "Stewart"));
        studentDTOS.add(new Student(4L, "Francis", "Pedro"));
        studentDTOS.add(new Student(5L, "Nolan", "Howard"));
        studentDTOS.add(new Student(6L, "Edmond", "Lopez"));

        return studentDTOS;
    }

    // {id} ==> URI Template Variable
    // http://localhost:8080/students/7/Howard/Hugues
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") Long studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
    ) {
        Student studentDTO = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    // Rest API with Request Params
    // http://localhost:8080/students/query?id=1&firstname=Franck&lastname=Dodo
    @GetMapping("/students/query")
    public Student studentRequestVariable(
            @RequestParam("id") Long studentId,
            @RequestParam("firstname") String studentFirstName,
            @RequestParam("lastname") String studentLastName
    ) {
        Student studentDTO = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    // Rest API that handles HTTP Post Request - Creating new resource
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student studentDTO) {
        Student student = Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();

        return student;
    }

    // Rest API that handles HTTP PUT Request - Updating existing resource
    // HTTP PUT Request : http://localhost:8080/students/1
    // {id} ==> URI Template variables
    @PutMapping("/students/{id}/update")
    public Student updateStudent(
            @PathVariable("id") Long studentId,
            @RequestBody Student studentRequested
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentRequested.getFirstName())
                .lastName(studentRequested.getLastName())
                .build();

        return student;
    }

}
