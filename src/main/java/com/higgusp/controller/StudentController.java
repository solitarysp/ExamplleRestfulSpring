package com.higgusp.controller;

import com.higgusp.Service.StudentService;
import com.higgusp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//khai báo resfull
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllUsers() {
        List<Student> Students1 = studentService.getAll();
        return new ResponseEntity<List<Student>>(Students1, HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method = RequestMethod.PUT)
    public boolean upDateStudent(@RequestBody Student student) {
        Boolean result=studentService.update(student);
        return result;
    }
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public boolean createStudent(@RequestBody Student student) {
        Boolean result=studentService.create(student);
        return result;
    }    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public boolean deleteStudent(@PathVariable Integer id) {
        Boolean result=studentService.delete(id);
        return result;
    }
}
