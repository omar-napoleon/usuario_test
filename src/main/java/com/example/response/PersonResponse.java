/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse implements Serializable{
    
    private String message;
    
    private Object person;

    public PersonResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPerson() {
        return person;
    }

    public void setPerson(Object person) {
        this.person = person;
    }

    public PersonResponse(String message, Object person) {
        this.message = message;
        this.person = person;
    }
    
    
    
    
}
