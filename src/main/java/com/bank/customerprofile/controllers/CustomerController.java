package com.bank.customerprofile.controllers;

import com.bank.customerprofile.models.DTOs.CustomerRequestDTO;
import com.bank.customerprofile.models.DTOs.CustomerResponseDto;
import com.bank.customerprofile.models.entities.Customer;
import com.bank.customerprofile.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid@RequestBody CustomerRequestDTO data){
        Customer response = customerService.createCustomer(data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getcustomerbyid/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allcustomers")
    public ResponseEntity<Page<CustomerResponseDto>> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return  ResponseEntity.ok(customerService.getAllCustomer(page,size,sortBy,direction));
    }


}
