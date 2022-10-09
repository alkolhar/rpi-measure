package com.example.rpimeasure;

import javax.persistence.*;

@Entity // Indicates JPA entity, translates to corresponding table in db
public class Customer {
    @Id // indicates object id
    @GeneratedValue(strategy = GenerationType.AUTO) // automatically generated
    private Integer id;

    private String firstName;
    private String lastName;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
