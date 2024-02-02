package com.handleexception.service;

import com.handleexception.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student createStudent(Student student);
    void deleteTheStudent(Long id);
}
