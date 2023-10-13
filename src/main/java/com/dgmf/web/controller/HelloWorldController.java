package com.dgmf.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // Http Get Request
    @GetMapping("/hello-world") // http://localhost:8080/hello-world
    public String helloWorld() {
        return "Hello World !";
    }
}
