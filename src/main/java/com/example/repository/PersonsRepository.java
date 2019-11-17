package com.example.repository;

import com.example.entity.Persons;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, UUID> {
    
    Persons findByEmail(String email);
    
}
