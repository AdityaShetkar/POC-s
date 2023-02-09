package com.reactive.controller;

import com.reactive.dto.Customer;
import com.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.loadAllCustomers();
    }

    @GetMapping(value = "/getAllCustomers1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomers1(){
        return customerService.loadAllCustomers1();
    }
}
