package com.bank.customerprofile.models.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "firstname cannot be empty")
    private String  firstname;

    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @NotBlank(message = "email cannot be empty!")
    @Email(message = "Enter a valid Email Format")
    private String email;

    private String phone;

}
