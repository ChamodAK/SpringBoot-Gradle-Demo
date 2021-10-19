package com.example.demo.service;

import com.example.demo.bean.CreateStudentRequest;
import com.example.demo.bean.UpdateStudentRequest;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO saveStudent(CreateStudentRequest request) {

        Student s = new Student();
        s.setName(request.getName());
        s.setAge(request.getAge());

        Student savedStudent = studentRepository.save(s);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(savedStudent.getId());
        studentDTO.setAge(savedStudent.getAge());
        studentDTO.setName(savedStudent.getName());
        studentDTO.setTimestamp(LocalDateTime.now());

        return studentDTO;

    }

    public List<StudentDTO> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();

        for(Student s : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(s.getId());
            studentDTO.setName(s.getName());
            studentDTO.setAge(s.getAge());
            studentDTO.setTimestamp(LocalDateTime.now());
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

//    public Page<Student> getAllStudents(Integer pageNo, Integer pageSize) {
//
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("name"));
//
//        Page<Student> pageResult = studentRepository.findAll(paging);
//
//        return pageResult;
//    }

    public StudentDTO getStudentById(Long id) {

        Student student = studentRepository.getById(id);

        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                LocalDateTime.now()
        );

        return studentDTO;

    }

    public StudentDTO updateStudent(Long id, UpdateStudentRequest request) {

        Optional<Student> s = studentRepository.findById(id);
        Student stu = s.get();
        stu.setName(request.getName());
        stu.setAge(request.getAge());

        Student savedStudent = studentRepository.save(stu);

        StudentDTO studentDTO = new StudentDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                LocalDateTime.now()
        );

        return studentDTO;

    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);

    }

    public List<Student> getAllStudentsByAge(int age) {

        List<Student> studentList = studentRepository.findStudentsByAge(age);
        return studentList;

    }

    public Student getStudentByName(String name) {

        Student student = studentRepository.findStudentByName(name);
        return student;

    }
}
