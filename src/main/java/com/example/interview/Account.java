package com.example.interview;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

    @Id
    @GeneratedValue
    public Integer id;

    public String iban;

    @ManyToOne
    public Customer customer;

}
