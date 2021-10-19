package com.example.demo.controller;

import com.example.demo.bean.CreateStudentRequest;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    StudentDTO studto1 = new StudentDTO(1L, "Robin", 23, LocalDateTime.now());
    StudentDTO studto2 = new StudentDTO(2L, "Batman", 33, LocalDateTime.now());
    StudentDTO studto3 = new StudentDTO(3L, "Alan", 42, LocalDateTime.now());

    @Test
    public void getAllStudents_success() throws Exception {

        List<StudentDTO> records = new ArrayList<StudentDTO>(Arrays.asList(studto1, studto2, studto3));

        Mockito.when(studentService.getAllStudents()).thenReturn(records);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].name", is("Batman")));

    }

    @Test
    public void createStudent_success() throws Exception {

        CreateStudentRequest request = new CreateStudentRequest(1L, "Batman", 23);

        Mockito.when(studentService.saveStudent(Mockito.any(CreateStudentRequest.class))).thenReturn(studto1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Robin")));

    }

}
