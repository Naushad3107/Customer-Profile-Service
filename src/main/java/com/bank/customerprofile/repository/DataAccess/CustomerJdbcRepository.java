package com.bank.customerprofile.repository.DataAccess;

import com.bank.customerprofile.models.DTOs.Customer.CreateCustomer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CustomerJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public CustomerJdbcRepository(JdbcTemplate _jdbctemplate){
        this.jdbcTemplate = _jdbctemplate;
    }

    public void CreateCustomer(CreateCustomer data){
        if (data == null) return;
        System.out.println(data);
        jdbcTemplate.update(
                "CALL Usp_Create_Customer(?,?,?,?,?,?,?,?,?,?,?)",
                data.getFirstname(),
                data.getLastname(),
                data.getEmail(),
                data.getPhone(),
                data.getLine1(),
                data.getCity(),
                data.getState(),
                data.getCountry(),
                data.getPincode(),
                data.getAlternateEmail(),
                data.getAlternatePhone()
        );
    }
}
