package com.customers.controller;

import com.customers.model.Customers;
import com.customers.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/customers")
public class CustomerController {

    @Autowired
    CustomersRepository customersRepository;
    @GetMapping(value="/all")
    public List<Customers> getAll(){
        return customersRepository.findAll();
    }

    @PostMapping(value = "/load")
    @ResponseStatus(HttpStatus.OK)
    public List<Customers> persist(@RequestBody final Customers customers){
        customersRepository.save(customers);
        return customersRepository.findAll();
    }
}
