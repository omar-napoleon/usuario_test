/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.entity.Persons;
import com.example.request.PersonRequest;
import com.example.repository.PersonsRepository;
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
    private JwtTokenUtil jwtTokenUtil;

    /**
     *
     * @param body
     * @return
     * @throws Exception
     */
    @Override
    public Persons addPerson(PersonRequest body) throws Exception {
        return personsRepository.save(fillObjectEntity(body));

    }

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public Persons getPersonInfoByEmail(String email) throws Exception {

        Persons p = personsRepository.findByEmail(email);
        if (p == null) {
            throw new EmptyResultDataAccessException(0);
        }
        return p;
    }

    private Persons fillObjectEntity(PersonRequest body) throws Exception {
        Persons p = new Persons();
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
        p.setPhones(body.getPhones());

        return p;
    }

}
