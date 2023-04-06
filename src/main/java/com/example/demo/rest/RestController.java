package com.example.demo.rest;

import com.example.demo.Repo.Service.ContactService;
import com.example.demo.Repo.Service.PersonService;
import com.example.demo.entity.Contact;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    public RestController(){

    }

    @Autowired
    private PersonService personService;

    @Autowired
    private ContactService contactService;

    /**
     *
     * @return all the contacts from database;
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/contact")
    public List<Contact> findAllContacts(){
        return contactService.getAllContact();
    }




    /**
     *
     * @param contact
     * @return which contact added to database
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/contact")
    public Contact createContact(@RequestBody Contact contact) {

       contact.setId(0);
       return contactService.saveContact(contact);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {

        person.setId(0);
        List<Contact> contacts = person.getContacts();

        for (Contact contact : contacts){
            contact.setPerson(person);
            contactService.saveContact(contact);
        }
        return personService.savePerson(person);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/person")
    public List<Person> findAllPerson(){
        List<Person> person = new ArrayList<>();
        personService.getAllPersons().forEach(person::add);
        return person;
    }


    @DeleteMapping("/contact/{id}")
    public void deleteById(@PathVariable int id){
        contactService.deleteContact(id);
    }
}
