package com.example.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ContactController {

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    @GetMapping("create/customer")
    public void create(@RequestParam String name){
        Customer customer = new Customer();
        customer.name = name;
        customerRepository.save(customer);
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable("id") Integer id){
        return customerRepository.findById(id).get();
    }

    @GetMapping("create/customer/{id}/account/{iban}")
    public void addAccountToCustomer(@PathVariable("id") Integer id, @PathVariable("iban") String iban) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(Exception::new);
        Account account = new Account();
        account.iban = iban;
        account.customer = customer;
        accountRepository.save(account);
    }

}
