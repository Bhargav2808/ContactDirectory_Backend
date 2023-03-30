package com.example.demo.rest;

import com.example.demo.Repo.Dao.ContactRepository;
import com.example.demo.Repo.Service.ContactService;
import com.example.demo.Repo.Service.PersonService;
import com.example.demo.entity.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    public EmployeeRestController(){

    }

    @Autowired
    private PersonService personService;

    @Autowired
    private ContactService contactService;

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




    @DeleteMapping("/contact/{id}")
    public void deleteById(@PathVariable int id){
        contactService.deleteContact(id);
    }
}
