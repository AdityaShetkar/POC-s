package com.reactive.service;

import com.reactive.dao.CustomerDao;
import com.reactive.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution time :" + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomers1(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomers1();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution time :" + (end - start));
        return customers;
    }

}
