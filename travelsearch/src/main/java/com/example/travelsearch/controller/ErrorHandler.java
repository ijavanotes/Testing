package com.example.travelsearch.controller;

import com.example.travelsearch.exception.SystemErrorException;
import com.example.travelsearch.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

@RestControllerAdvice
public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);



    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ResponseDTO> servletError(ServletException exception){
        logger.error("system error", exception);

        return new ResponseEntity<ResponseDTO>(new  ResponseDTO(400,"System error"), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> messageReadException(RuntimeException exception){
        logger.error("system error", exception);

        return new ResponseEntity<ResponseDTO>(new  ResponseDTO(400,"System error"), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(SystemErrorException.class)
    public ResponseEntity<ResponseDTO> systemReadException(SystemErrorException exception){
        logger.error("system error", exception);

        return new ResponseEntity<ResponseDTO>(new  ResponseDTO(400,"System error"), HttpStatus.BAD_REQUEST);

    }

}
