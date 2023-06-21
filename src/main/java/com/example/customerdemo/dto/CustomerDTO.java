package com.example.customerdemo.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerNumber;

    private String customerName;

    private String contactLastName;

    private String contactFirstName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Long salesRepEmployeeNumber;

    private Float creditLimit;
}
