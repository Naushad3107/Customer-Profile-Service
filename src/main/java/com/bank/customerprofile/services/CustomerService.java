package com.bank.customerprofile.services;

import com.bank.customerprofile.models.DTOs.CustomerRequestDTO;
import com.bank.customerprofile.models.entities.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(CustomerRequestDTO data);

    Optional<Customer> getCustomerByEmail(String data);

    Customer getCustomerById(Long Id);
}
