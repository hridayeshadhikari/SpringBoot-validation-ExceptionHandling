package com.handleexception.service.impl;

import com.handleexception.Exception.StudentExistException;
import com.handleexception.Exception.StudentNotFoundException;
import com.handleexception.entity.Student;
import com.handleexception.repository.StudentRepository;
import com.handleexception.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        List<Student> students=studentRepository.findAll();
        return students;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("no student found with id "+id));
    }

    @Override
    public Student createStudent(Student student) {
        Optional<Student> isStudentExist=studentRepository.findById(student.getStudId());
        if(isStudentExist.isPresent()){
            throw new StudentExistException("student already exist with id "+student.getStudId());
        }
        return studentRepository.save(student);
    }

    @Override
    public void deleteTheStudent(Long id) {
        Optional<Student> isExist=studentRepository.findById(id);
        if(isExist.isEmpty()){
            throw new StudentNotFoundException("no student found with id "+id);
        }

        studentRepository.deleteById(id);

    }
}
