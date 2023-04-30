package com.thEkip.Hotel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long customerId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;
}
