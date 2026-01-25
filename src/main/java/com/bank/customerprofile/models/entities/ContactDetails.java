package com.bank.customerprofile.models.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactDetails {
    private String alternateEmail;
    private String alternatePhone;
}
