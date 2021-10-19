package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class StudentRepositoryCustomImpl implements  StudentRepositoryCustom {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String GET_STUDENTS_BY_AGE = "SELECT * " +
            "FROM student_db.students " +
            "WHERE age = :age;";

    private final String GET_STUDENT_BY_NAME = "SELECT * " +
            "FROM student_db.students " +
            "WHERE name = :name; ";

    @Override
    public List<Student> findStudentsByAge(int age) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("age", age);

        List<Student> studentList = namedParameterJdbcTemplate.query(GET_STUDENTS_BY_AGE, parameters, new StudentMapper());
        return studentList;

    }

    @Override
    public Student findStudentByName(String name) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", name);

        Student student = (Student) namedParameterJdbcTemplate.queryForObject(GET_STUDENT_BY_NAME, parameters, new StudentMapper());
        return student;

    }
}
