/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.request.PersonRequest;
import com.example.response.PersonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.PersonsService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author usuario
 */
@Api(value = "API REST FULL")
@RestController
public class PersonsController {

    @Autowired
    private PersonsService personsService;

    /**
     *
     * @param body
     * @return
     * @throws AuthenticationException
     * @throws Exception
     */
    @ApiOperation(value = "crea la informacion de una persona", response = PersonResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "persona guardada exitosamente", response = PersonRequest.class)
        ,
    @ApiResponse(code = 500, message = "Error interno",response = PersonResponse.class)
    })
    @PostMapping(value = "${jwt.route.authentication.path}", produces = {"application/json"})
    public ResponseEntity<?> addPersons(
            @ApiParam(value = "atribustos de la persona a crear", required = true)
            @Valid @RequestBody PersonRequest body) throws AuthenticationException, Exception {

        return new ResponseEntity<>(new PersonResponse("OK",
                personsService.addPerson(body)), HttpStatus.OK);

    }
    
    /**
     *
     * @param email
     * @return
     * @throws java.lang.Exception
     */
    @ApiOperation(value = "Busca la informaión de una persona a traves de su email", response = PersonResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Recuperada la informaión de una persona exitosamente", response = PersonResponse.class)
        ,
    @ApiResponse(code = 404, message = "No se encuentra el recurso", response = PersonResponse.class)
        ,
    @ApiResponse(code = 500, message = "Error interno", response = PersonResponse.class)
    })
    @GetMapping(value = "/persons/{email}", produces = {"application/json"})
    public ResponseEntity<?> getPersonByEmail(
            @ApiParam(value = "Email", required = true)
            @Valid @PathVariable("email") String email) throws Exception {

        return new ResponseEntity<>(new PersonResponse("OK", 
                personsService.getPersonInfoByEmail(email)), HttpStatus.OK);

    }

}
