package com.bank.customerprofile.models.DTOs;

import com.bank.customerprofile.models.entities.Address;
import com.bank.customerprofile.models.entities.ContactDetails;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {

    @NotBlank(message = "firstname cannot be empty")
    private String  firstname;

    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @NotBlank(message = "email cannot be empty!")
    @Email(message = "Enter a valid Email Format")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    private Address address;

    private ContactDetails contactDetails;

}
