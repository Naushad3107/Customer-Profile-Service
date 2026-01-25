package com.bank.customerprofile.controllers;

import com.bank.customerprofile.models.DTOs.CustomerRequest;
import com.bank.customerprofile.models.entities.Customer;
import com.bank.customerprofile.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid@RequestBody CustomerRequest data){
        Customer response = customerService.createCustomer(data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
