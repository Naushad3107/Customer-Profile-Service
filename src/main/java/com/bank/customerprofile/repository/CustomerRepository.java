package com.bank.customerprofile.repository;

import com.bank.customerprofile.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String Email);

    boolean existsByEmail(String email);

}
