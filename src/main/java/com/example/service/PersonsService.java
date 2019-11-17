/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.request.PersonRequest;
import com.example.entity.Person;

/**
 *
 * @author usuario
 */
public interface PersonsService {

    public Person getPersonInfoByEmail(String email) throws Exception;
    
    public PersonRequest addPerson(PersonRequest body) throws Exception;

}
