package com.thEkip.Hotel.api.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.entities.Reservation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CustomerAddRequest {

    private String name;
    private String email;
    private String phoneNumber;

    public Customer createOneCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setEmail(this.email);
        newCustomer.setName(this.name);
        newCustomer.setPhoneNumber(this.name);
        return newCustomer;
    }

}
