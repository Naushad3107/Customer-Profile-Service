package com.bank.customerprofile.models.DTOs;

import com.bank.customerprofile.models.entities.Address;
import com.bank.customerprofile.models.entities.ContactDetails;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CustomerResponseDto {

    private Long id;

    private String  firstname;

    private String lastname;

    private String email;

    private String phone;

    private Address address;

    private ContactDetails contactDetails;


}
