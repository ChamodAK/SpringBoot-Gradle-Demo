package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class StudentDTO {

    private Long id;
    private String name;
    private int age;
    private LocalDateTime timestamp;

}
