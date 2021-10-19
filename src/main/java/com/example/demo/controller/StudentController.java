package com.example.demo.controller;

import com.example.demo.bean.CreateStudentRequest;
import com.example.demo.bean.UpdateStudentRequest;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String serviceCheck() {
        return "Student service is working ...";
    }

    @PostMapping("/students")
    @ResponseBody
    public StudentDTO createStudent(@RequestBody CreateStudentRequest request) {
        StudentDTO studentDTO = studentService.saveStudent(request);
        return studentDTO;
    }

    @GetMapping("/students")
    @ResponseBody
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentList = studentService.getAllStudents();
        return studentList;
    }

//    @GetMapping("/students")
//    @ResponseBody
//    public Page<Student> getAllStudents(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "2") Integer pageSize) {
//        Page<Student> pageResult = studentService.getAllStudents(pageNo, pageSize);
//        return pageResult;
//    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public StudentDTO getStudentById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO;
    }

    @PutMapping("/students/{id}")
    @ResponseBody
    public StudentDTO updateStudent(@PathVariable Long id, UpdateStudentRequest request) {
        StudentDTO studentDTO = studentService.updateStudent(id, request);
        return studentDTO;
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Record deleted successfully";
    }

    @GetMapping("/students/age/{age}")
    @ResponseBody
    public List<Student> getAllStudentsByAge(@PathVariable int age) {
        List<Student> studentList = studentService.getAllStudentsByAge(age);
        return studentList;
    }

    @GetMapping("/students/name/{name}")
    @ResponseBody
    public Student getStudentByName(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        return student;
    }

    //Comment Added


}