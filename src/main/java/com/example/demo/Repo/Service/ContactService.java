package com.example.demo.Repo.Service;

import com.example.demo.Repo.Dao.ContactRepository;
import com.example.demo.Repo.Dao.PersonRepository;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getPersonById(int id) {
        return contactRepository.findById(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
}
