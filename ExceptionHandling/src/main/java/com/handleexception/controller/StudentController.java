package com.handleexception.controller;

import com.handleexception.entity.Student;
import com.handleexception.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid Student student){
        Student newStudent=studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable  Long id){
        Student newStudent=studentService.getById(id);
        return new ResponseEntity<>(newStudent, HttpStatus.FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.deleteTheStudent(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public List<Student> getStudents(){
        return studentService.getAll();
    }
}
