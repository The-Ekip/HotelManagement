package com.thEkip.Hotel.service.abstracts;

import com.thEkip.Hotel.api.dto.requests.CustomerAddRequest;
import com.thEkip.Hotel.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer createOneCustomer(CustomerAddRequest request);

    Customer getOneCustomer(long customerId);
}
