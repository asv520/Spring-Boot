package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Yash", "Rawat"));
        theStudents.add(new Student("Piyush", "Gehlot"));
        theStudents.add(new Student("Ayush", "Verma"));

        return theStudents;
    }
}




