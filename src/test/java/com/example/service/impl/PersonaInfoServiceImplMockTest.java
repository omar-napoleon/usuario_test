///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.service.impl;
//
//import com.example.entity.Persons;
//import com.example.enums.HairColourEnum;
//import com.example.repository.PersonaRepository;
//import java.util.Optional;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.example.service.PersonsService;
//
///**
// *
// * @author usuario
// */
//@RunWith(MockitoJUnitRunner.class)
//public class PersonaInfoServiceImplMockTest {
//    
//    @Mock
//    private PersonaRepository personaRepository;
//    
//    @InjectMocks
//    private PersonsService personaInfoService = new PersonsServiceImpl();
//    
//
//    /**
//     * Test of getPersonaInfoById method, of class PersonaInfoServiceImpl.
//     */
//    @Test
//    public void testGetPersonaInfoById() throws Exception {
//        Persons instance = new Persons(1,"omar","guillen","santiago", 123445, HairColourEnum.brown);
//        when(personaRepository.findById(1)).thenReturn(Optional.of(instance));
//        assertEquals(instance, personaInfoService.getPersonaInfoById(1));
//    }
//    
//}
