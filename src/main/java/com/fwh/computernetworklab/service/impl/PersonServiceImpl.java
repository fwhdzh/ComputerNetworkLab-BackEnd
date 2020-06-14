package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.dao.PersonRepository;
import com.fwh.computernetworklab.domain.Person;
import com.fwh.computernetworklab.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Save Person to Ignite DB
     * @param person Person object.
     * @return The Person object saved in Ignite DB.
     */
    public Person save(Person person) {
        // If this username is not used then return null, if is used then return this Person
        return personRepository.save(person.getId(), person);
    }

    /**
     * Find a Person from Ignite DB with given name.
     * @param name Person name.
     * @return The person found in Ignite DB
     */
    public Person findPersonByUsername(String name){
        return personRepository.findByUsername(name);
    }

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }


}
