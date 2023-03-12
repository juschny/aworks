package com.jcode.aworks.controllers;

import com.jcode.aworks.models.Person;
import com.jcode.aworks.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ArrayList<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping()
    public Person savePerson(@RequestBody Person person ) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/query")
    public ArrayList<Person> getPersonByApellido(@RequestParam("apellido") String apellido) {
        return personService.getPersonByApellido(apellido);
    }

    @DeleteMapping("/{id}")
    public String removePerson(@PathVariable("id") Long id) {
        if(personService.removePerson(id)){
            return "se elimino la persona de id " + id + " de la base de datos.";
        } else {
            return "la persona no esta en la base de datos.";
        }
    }


}
