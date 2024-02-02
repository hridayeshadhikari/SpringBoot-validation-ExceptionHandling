package com.handleexception.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(StudentExistException.class)
    public ResponseEntity<?> studentExistException(StudentExistException stud) {
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.OK.value());
        errorDetails.setErrMessage(stud.getMessage());
        errorDetails.setStatus(HttpStatus.OK.name());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.OK);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFoundException(StudentNotFoundException stud) {
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setErrMessage(stud.getMessage());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.name());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodValidation(MethodArgumentNotValidException vad) {
        List<String> fieldError=vad.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        Map<String,Object> errorMap=new HashMap<>();
        errorMap.put("status code",HttpStatus.BAD_REQUEST.value());
        errorMap.put("status",HttpStatus.BAD_REQUEST.name());
        errorMap.put("time stamp",LocalDateTime.now());
        errorMap.put("error message",fieldError);
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
}
