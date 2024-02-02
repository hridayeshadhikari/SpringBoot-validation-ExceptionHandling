package com.handleexception.Exception;

public class StudentExistException extends RuntimeException{
    public StudentExistException(String mes){
        super(mes);
    }
}
