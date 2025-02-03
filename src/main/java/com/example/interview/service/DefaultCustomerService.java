package com.example.interview.service;

import com.example.interview.api.ContactDto;
import com.example.interview.api.CustomerDto;
import com.example.interview.model.Contact;
import com.example.interview.model.Customer;
import com.example.interview.repository.ContactRepository;
import com.example.interview.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultCustomerService implements CustomerService{

    private final CustomerRepository customerRepository;

    private final ContactRepository contactRepository;

    @Override
    @Transactional
    public CustomerDto create(String name) {
        Customer customer = Customer.builder()
                .name(name)
                .build();
        return toDto(customerRepository.save(customer));
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        return customerRepository.findById(id).map(DefaultCustomerService::toDto);
    }

    @Override
    public ContactDto addAccountToCustomer(Long customerId, ContactDto contactDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);
        Contact contact = Contact.builder()
                .name(contactDto.getName())
                .customer(customer)
                .build();
        return toDto(contactRepository.save(contact));
    }

    private static CustomerDto toDto(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .contacts(customer.getContacts().stream().map(DefaultCustomerService::toDto).collect(Collectors.toSet()))
                .build();
    }

    private static ContactDto toDto(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .build();
    }


}
