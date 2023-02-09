package com.reactivemysql.repository;

import com.reactivemysql.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends ReactiveCrudRepository<Customer, Integer> {

}
