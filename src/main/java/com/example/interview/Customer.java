package com.example.interview;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    public Integer id;

    public String name;

    @OneToMany(mappedBy = "customer")
    public Set<Account> accounts;

}
