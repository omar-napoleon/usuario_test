/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import com.example.repository.PersonsRepository;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author usuario
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonsTest {
    
    @Autowired
    private PersonsRepository personsRepository;
    
    public PersonsTest() {
    }
    
    

    /**
     * Test of getId method, of class PersonaInfo.
     */
    @Test
    public void testSavePerson() {
        System.out.println("addPerson");
        Person instance = new Person(null, "omar guillen", "omar@omar.com", 
                "Inv34ls", "gasgw", true, new Date(), new Date());
        
        Person returnPerson =personsRepository.save(instance);
        
        assertTrue(returnPerson.getEmail().equals(instance.getEmail()));
    }


}
