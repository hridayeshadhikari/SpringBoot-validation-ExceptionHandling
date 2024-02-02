package com.handleexception.Exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String mes){
        super(mes);
    }
}
