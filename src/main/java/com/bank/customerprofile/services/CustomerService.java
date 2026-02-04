package com.bank.customerprofile.services;

import com.bank.customerprofile.models.DTOs.CustomerRequestDTO;
import com.bank.customerprofile.models.DTOs.CustomerResponseDto;
import com.bank.customerprofile.models.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(CustomerRequestDTO data);

    Optional<Customer> getCustomerByEmail(String data);

    Customer getCustomerById(Long Id);

    Page<CustomerResponseDto> getAllCustomer(int page, int size, String sortBy, String Direction);
}
