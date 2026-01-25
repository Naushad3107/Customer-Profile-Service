package com.bank.customerprofile.models.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String line1;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
