package com.example.redis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.redis.repository.PersonRepo;
import com.example.redis.entity.Person;
import org.springframework.stereotype.Service;
@Service
public class PersonService {


    private final PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public Person addPerson(Person person){
        return repo.save(person);
    }
    public List<Person> getAllPersons(){
        List<Person> allPerson = new ArrayList<>();
        repo.findAll().forEach(allPerson::add);
        return allPerson;
    }

    public Person getPersonById(int id){
        Optional<Person> optionalPerson = repo.findById(String.valueOf(id));
        return optionalPerson.orElse(null);
    }


    public Person updatePersonById(int id, Person person){
        Optional<Person> existingCustomer  = repo.findById(String.valueOf(id));
        if (existingCustomer.isPresent()) {
            Person updatedPerson = existingCustomer.get();
            updatedPerson.setName(person.getName());
            updatedPerson.setMobile(person.getMobile());
            updatedPerson.setEmail(person.getEmail());
            repo.deleteById(String.valueOf(id));
            return repo.save(updatedPerson);
        }

        return null;
    }

    public void deletePersonById(int id){
        repo.deleteById(String.valueOf(id));
    }
}