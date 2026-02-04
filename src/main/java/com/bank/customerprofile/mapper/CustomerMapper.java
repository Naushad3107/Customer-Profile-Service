package com.bank.customerprofile.mapper;

import com.bank.customerprofile.models.DTOs.CustomerResponseDto;
import com.bank.customerprofile.models.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static CustomerResponseDto toDTO(Customer customer){

        return CustomerResponseDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .contactDetails(customer.getContactdetails())
                .build();
    }
}
