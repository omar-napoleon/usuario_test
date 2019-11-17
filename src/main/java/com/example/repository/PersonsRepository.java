package com.example.repository;

import com.example.entity.Person;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends JpaRepository<Person, UUID> {
    
    Person findByEmail(String email);
    
}
