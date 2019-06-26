package com.controller;

import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){
        request.setAttribute("hello", "hello");
        request.setAttribute("users", studentService.findStudentAll());
        return "test";
    }

}
