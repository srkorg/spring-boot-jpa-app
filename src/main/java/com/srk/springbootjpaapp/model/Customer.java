package com.srk.springbootjpaapp.model;

import com.fasterxml.uuid.Generators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Customer {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    //@Column(columnDefinition = "BINARY(32)")
    private UUID id = Generators.timeBasedGenerator().generate();
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id='%s', firstName='%s', lastName='%s']",
                getId().toString(), getFirstName(), getLastName());
    }

}