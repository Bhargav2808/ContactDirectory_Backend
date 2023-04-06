package com.example.demo.Repo.Service;

import com.example.demo.Repo.Dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    public List<Person> getAllPersons() {
        System.out.println(personRepository.findAll());
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {

        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
