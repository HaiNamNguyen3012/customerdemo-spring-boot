package com.example.customerdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString

public class Customer {
    @Id
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
