package com.handleexception.Exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private int statusCode;
    private String errMessage;
    private String status;
    private LocalDateTime timeStamp;
}
