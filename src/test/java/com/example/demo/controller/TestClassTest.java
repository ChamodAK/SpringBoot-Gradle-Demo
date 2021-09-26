package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAssertThatEqual() {
        assertEquals(4, 4);
    }


//    @Test
//    public void testServiceCheck() throws UnsupportedEncodingException {
//        // when
//        MockHttpServletResponse response = mvc.perform(get("/")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("Working :: 30").getJson();
//    }

}