package com.jcode.aworks.repositories;

import com.jcode.aworks.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface PersonRepository extends JpaRepository<Person, Long> {
    public abstract ArrayList<Person> findByApellido(String apellido);
}
