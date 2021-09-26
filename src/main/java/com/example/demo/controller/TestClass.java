package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {

    @GetMapping("/")
    public String serviceCheck() {
        int a = 10;
        int b = 20;
        int c = a + b;
        return "Working :: " + c;
    }
    
}