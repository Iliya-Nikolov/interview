package com.example.interview.controller;

import com.example.interview.api.CustomerDto;
import com.example.interview.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers/")
public class ContactController {

    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.create(customerDto.getName()));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.of(customerService.findById(id));
    }

    @PostMapping("{id}/accounts")
    public ResponseEntity<CustomerDto> addAccountToCustomer(@PathVariable("id") Long id){
        return ResponseEntity.of(customerService.findById(id));
    }

}
