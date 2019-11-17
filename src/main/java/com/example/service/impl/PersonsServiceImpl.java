/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.entity.Person;
import com.example.entity.Phone;
import com.example.request.PersonRequest;
import com.example.repository.PersonsRepository;
import com.example.repository.PhonesRepository;
import com.example.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.service.PersonsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author usuario
 */
@Service
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private PhonesRepository phonesRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     *
     * @param body
     * @return
     * @throws Exception
     */
    @Override
    public PersonRequest addPerson(PersonRequest body) throws Exception {

        Person person = fillObjectEntityPerson(body);

        personsRepository.save(person);

        List<Phone> phones = body.getPhones();

        phones.forEach(item -> item.setPersonId(person.getId()));

        phonesRepository.saveAll(phones);

        body.setId(person.getId().toString());
        body.setToken(person.getToken());
        body.setIsActive(person.getIsActive());
        body.setCreated(person.getCreated());
        body.setLastLogin(person.getLastLogin());

        return body;

    }

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public Person getPersonInfoByEmail(String email) throws Exception {

        Person p = personsRepository.findByEmail(email);
        if (p == null) {
            throw new EmptyResultDataAccessException(0);
        }
        return p;
    }

    private Person fillObjectEntityPerson(PersonRequest body) throws Exception {
        Person p = new Person();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserDetails userDetails = new User(body.getEmail(), body.getPassword(), authorities);
        String token = jwtTokenUtil.generateToken(userDetails);

        p.setName(body.getName());
        p.setPassword(encoder.encode(body.getPassword()));
        p.setEmail(body.getEmail());
        p.setIsActive(Boolean.TRUE);
        p.setCreated(new Date());
        p.setLastLogin(new Date());
        p.setToken(token);

        return p;
    }

}
