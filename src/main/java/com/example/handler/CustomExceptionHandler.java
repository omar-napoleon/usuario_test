/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.handler;

import com.example.response.PersonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author usuario
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Provides handling for standard Spring MVC exceptions.
     *
     * @param e the target exception
     * @param request the current request
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class,
        EmptyResultDataAccessException.class,
        MethodArgumentTypeMismatchException.class,
        UnsupportedOperationException.class,
        DataIntegrityViolationException.class,
        MethodArgumentNotValidException.class,
        Exception.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
        PersonResponse response = new PersonResponse();
        String message = null;
        response.setMessage(e.getMessage());
        HttpStatus status = HttpStatus.ACCEPTED;

        if (e instanceof IllegalArgumentException) {
            status = HttpStatus.NOT_FOUND;
        } else if (e instanceof EmptyResultDataAccessException) {
            status = HttpStatus.NOT_FOUND;
            message = "Not found person";
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            status = HttpStatus.BAD_REQUEST;
        } else if(e instanceof MethodArgumentNotValidException){
            message = "bad request";
            status = HttpStatus.BAD_REQUEST;
        } else if (e instanceof InvalidFormatException) {
            message = "Invalid data body";
            status = HttpStatus.BAD_REQUEST;
        } else if (e instanceof DataIntegrityViolationException) {
            status = HttpStatus.BAD_REQUEST;
            message = "El correo ya registrado";
        } else if (e instanceof UnsupportedOperationException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (e instanceof Exception) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if(message != null) {
            response.setMessage(message);
        }

        return new ResponseEntity(response, status);
    }
    
    /**
     *
     * @param e
     * @param request
     * @return 
     * @throws UsernameNotFoundException
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleHeaderException(UsernameNotFoundException e, WebRequest request) throws Exception {

        PersonResponse response = new PersonResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
    }
}
