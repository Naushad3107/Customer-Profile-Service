package com.bank.customerprofile.service_impl;

import com.bank.customerprofile.exceptions.CustomerNotFoundException;
import com.bank.customerprofile.mapper.CustomerMapper;
import com.bank.customerprofile.models.DTOs.CustomerRequestDTO;
import com.bank.customerprofile.models.DTOs.CustomerResponseDto;
import com.bank.customerprofile.models.entities.Customer;
import com.bank.customerprofile.repository.CustomerRepository;
import com.bank.customerprofile.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerrepository;

//    public CustomerServiceImpl(CustomerRepository customerrepository){
//        this.customerrepository= customerrepository;
//    }

    @Override
    public Customer createCustomer(CustomerRequestDTO data){
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
    public Customer getCustomerById(Long Id){
        return customerrepository.findById(Id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with id: " + Id));
    }

    @Override
    public Page<CustomerResponseDto> getAllCustomer(int page, int size, String sortBy, String Direction){

        Sort sort = Direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);

        return customerrepository.findAll(pageable).map(CustomerMapper::toDTO);

    }
}
