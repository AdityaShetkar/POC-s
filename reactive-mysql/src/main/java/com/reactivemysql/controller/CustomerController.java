package com.reactivemysql.controller;

import com.reactivemysql.dto.CustomerDTO;
import com.reactivemysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Mono<CustomerDTO> saveCustomer(@RequestBody Mono<CustomerDTO> customerDTOMono){
        return this.customerService.createCustomer(customerDTOMono);
    }

    @GetMapping("/getAllCustomers")
    public Flux<CustomerDTO> getAllUsers(){
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/getCustomerById")
    public Mono<CustomerDTO> getCustomerById(@RequestParam("customerId") int customerId){
        return this.customerService.getCustomerById(customerId);
    }

    @PutMapping("/update")
    public Mono<CustomerDTO> updateCustomer(@RequestBody Mono<CustomerDTO> customerDTOMono, @RequestParam("customerId") int customerId){
        return this.customerService.updateCustomer(customerDTOMono, customerId);
    }

    @DeleteMapping("/delete")
    public Mono<Void> deleteCustomer(@RequestParam("customerId") int customerId){
        return this.customerService.deleteCustomer(customerId);
    }
}
