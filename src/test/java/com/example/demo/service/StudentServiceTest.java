package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

//    @Autowired
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    Student stu1 = Student.builder().id(1L).name("Charles").age(32).build();
    Student stu2 = Student.builder().id(1L).name("Charles").age(32).build();
    Student stu3 = Student.builder().id(1L).name("Charles").age(32).build();

    @Test
    public void getAllStudents_should_return_all_students() {

        List<Student> studentList = new ArrayList<>(Arrays.asList(stu1, stu2, stu3));

        when(studentRepository.findAll()).thenReturn(studentList);

        List<StudentDTO> result = studentService.getAllStudents();
        assertEquals(result.size(), 3);

    }

}
