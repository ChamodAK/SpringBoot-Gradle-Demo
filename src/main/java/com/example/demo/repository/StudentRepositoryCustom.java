package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepositoryCustom {

    public List<Student> findStudentsByAge(int age);

    public Student findStudentByName(String name);

}
