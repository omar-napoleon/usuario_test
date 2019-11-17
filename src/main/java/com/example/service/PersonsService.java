/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.request.PersonRequest;
import com.example.entity.Persons;

/**
 *
 * @author usuario
 */
public interface PersonsService {

    public Persons getPersonInfoByEmail(String email) throws Exception;
    
    public Persons addPerson(PersonRequest body) throws Exception;

}
