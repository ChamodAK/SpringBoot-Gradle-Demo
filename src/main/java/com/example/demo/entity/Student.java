package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "student_db", name = "students")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Age")
    private int age;

}
