package com.reactivemysql.service;

import com.reactivemysql.dto.CustomerDTO;
import com.reactivemysql.repository.CustomerRepo;
import com.reactivemysql.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired(required = true)
    private CustomerRepo customerRepo;

    @Override
    public Mono<CustomerDTO> createCustomer(Mono<CustomerDTO> customerDTOMono){
        return customerDTOMono.map(AppUtils::dtoToEntity)
                .flatMap(customerRepo::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Flux<CustomerDTO> getAllCustomers(){
        return this.customerRepo.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<CustomerDTO> getCustomerById(int customerId){
        return this.customerRepo.findById(customerId).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<CustomerDTO> updateCustomer(Mono<CustomerDTO> customerDTOMono, int customerId){
        return this.customerRepo.findById(customerId)
                .flatMap(c->customerDTOMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setCustomerId(customerId)))
                .flatMap(customerRepo::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<Void> deleteCustomer(int customerId){
        return this.customerRepo.deleteById(customerId);
    }

}
