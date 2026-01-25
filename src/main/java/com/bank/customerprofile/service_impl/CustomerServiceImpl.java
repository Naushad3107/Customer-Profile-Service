package com.bank.customerprofile.service_impl;

import com.bank.customerprofile.models.DTOs.CustomerRequest;
import com.bank.customerprofile.models.entities.Customer;
import com.bank.customerprofile.repository.CustomerRepository;
import com.bank.customerprofile.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerrepository;

//    public CustomerServiceImpl(CustomerRepository customerrepository){
//        this.customerrepository= customerrepository;
//    }

    @Override
    public Customer createCustomer(CustomerRequest data){
        //logic to check the duplicate of customers
        customerrepository.findByEmail(data.getEmail())
                .ifPresent(c -> { throw new RuntimeException("Customer Already Exist With This Email " + data.getEmail() );
                });

        Customer customer = Customer.builder()
                .firstname(data.getFirstname())
                .lastname(data.getLastname())
                .email(data.getEmail())
                .phone(data.getPhone())
                .build();


        return  customerrepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String data){
        return  customerrepository.findByEmail(data);
    }

    @Override
    public Optional<Customer> getCustomerById(Long Id){
        return customerrepository.findById(Id);
    }
}
