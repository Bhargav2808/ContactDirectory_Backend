package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name="contact")
public class Contact {

    public Contact(){

    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Contact(int person_id, String contactNo) {
        this.person_id = person_id;
        this.contactNo = contactNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Column(name = "person_id")
    private int person_id;

    @Column(name="contact_no")
    private String contactNo;
}
