package com.bank.customerprofile.services;

import com.bank.customerprofile.models.DTOs.CustomerRequest;
import com.bank.customerprofile.models.entities.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(CustomerRequest data);

    Optional<Customer> getCustomerByEmail(String data);

    Optional<Customer> getCustomerById(Long Id);
}
