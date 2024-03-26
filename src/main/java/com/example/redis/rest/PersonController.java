package com.example.redis.rest;

import java.util.List;

import com.example.redis.entity.Person;
import com.example.redis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/save")
    public Person addPerson(@RequestBody Person person){
        return service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getListOfPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/getById/{id}")
    public Person getPerson(@PathVariable int id){
        return service.getPersonById(id);
    }

    @PutMapping("updateById/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person){
        return service.updatePersonById(id, person);

    }

    @DeleteMapping("deleteById/{id}")
    public String deletePerson(@PathVariable int id){
        service.deletePersonById(id);
        return "Person Deleted Successfully";
    }
}
