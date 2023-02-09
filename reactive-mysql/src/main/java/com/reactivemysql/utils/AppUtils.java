package com.reactivemysql.utils;

import com.reactivemysql.dto.CustomerDTO;
import com.reactivemysql.model.Customer;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static CustomerDTO entityToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public static Customer dtoToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}
