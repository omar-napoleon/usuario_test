/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.configuration.WebSecurityConfig;
import com.example.entity.Person;
import com.example.entity.Phone;
import com.example.request.PersonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.service.PersonsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 *
 * @author usuario
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(WebSecurityConfig.class)
public class PersonsControllerTest {
  
    @MockBean
    private PersonsService personService;
    
    @Autowired
    private MockMvc mvc;

    private PersonRequest instance;
    
    private Phone phone;

    @Test
    public void testGetPersonaInfoById() throws Exception {
        
        ObjectMapper mapper = new ObjectMapper();
        
        phone = new Phone(null, "12345", "2", "1");
        List<Phone> phones = new ArrayList<>();
        
        PersonRequest request = new PersonRequest();
        
        request.setName("0mar guillen");
        request.setPassword("Inv34ls");
        request.setEmail("omar@omar.com");
        request.setCreated(new Date());
        request.setLastLogin(new Date());
        request.setPhones(phones);
        
        
        instance = new PersonRequest();
        
        
        phones.add(phone);
        instance.setPhones(phones);
        
        given(personService.addPerson(request)).willReturn(instance);

        mvc.perform(MockMvcRequestBuilders
                .post("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }


}
