package com.thEkip.Hotel.service.concretes;

import com.thEkip.Hotel.api.dto.requests.CustomerAddRequest;
import com.thEkip.Hotel.dao.CustomerRepository;
import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.EntityNotFoundException;
import com.thEkip.Hotel.service.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createOneCustomer(CustomerAddRequest request) {
        Customer customer =new Customer();
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getOneCustomer(long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException("customer"));
    }
}
