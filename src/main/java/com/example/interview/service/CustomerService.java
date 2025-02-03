package com.example.interview.service;

import com.example.interview.api.ContactDto;
import com.example.interview.api.CustomerDto;
import java.util.Optional;

public interface CustomerService {

    CustomerDto create(String name);

    Optional<CustomerDto> findById(Long id);

    ContactDto addAccountToCustomer(Long customerId, ContactDto contactDto);


}
