package com.thEkip.Hotel.api.controllers;

import com.thEkip.Hotel.api.dto.requests.CustomerAddRequest;
import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity createOneCustomer(@RequestBody CustomerAddRequest request){
            Customer returnCustomer= customerService.createOneCustomer(request);
        return ResponseEntity.ok(returnCustomer);
    }

//    @GetMapping("/{customerId}")
//    public
}
