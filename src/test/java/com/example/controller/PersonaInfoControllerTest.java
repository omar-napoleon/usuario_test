///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.controller;
//
//import com.example.entity.Persons;
//import com.example.enums.HairColourEnum;
//import com.example.repository.PersonaRepository;
//import com.example.service.impl.PersonsServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.Optional;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import static org.mockito.BDDMockito.given;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import com.example.service.PersonsService;
//
///**
// *
// * @author usuario
// */
//@RunWith(SpringRunner.class)
//@WebMvcTest(PersonsController.class)
//public class PersonaInfoControllerTest {
//  
//    @MockBean
//    private PersonsService personaInfoService;
//    
//    @Autowired
//    private MockMvc mvc;
//
//    private Persons instance;
//
//    @Test
//    public void testGetPersonaInfoById() throws Exception {
//
//        instance = new Persons(1, "omar", "guillen", "santiago", 123445, HairColourEnum.brown);
//        
//        given(personaInfoService.getPersonaInfoById(1)).willReturn(instance);
//
//        mvc.perform(MockMvcRequestBuilders
//                .get("/personas/{id}", 1)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(instance)));
//    }
//
//
//}
