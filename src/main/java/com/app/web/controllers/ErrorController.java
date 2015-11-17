package com.app.web.controllers;

import com.app.exceptions.ResourceNotFoundException;
import com.app.web.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler({ ResourceNotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(Exception e) {
        return new ResponseEntity<Object>(new ErrorResponseDto(e), HttpStatus.NOT_FOUND);
    }
}
