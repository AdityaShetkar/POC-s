package com.reactivemysql.service;

import com.reactivemysql.dto.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<CustomerDTO> createCustomer(Mono<CustomerDTO> customerDTOMono);

    Flux<CustomerDTO> getAllCustomers();

    Mono<CustomerDTO> getCustomerById(int customerId);

    Mono<CustomerDTO> updateCustomer(Mono<CustomerDTO> customerDTOMono, int customerId);

    Mono<Void> deleteCustomer(int customerId);
}
