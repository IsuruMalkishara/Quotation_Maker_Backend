package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;
import java.util.Optional;

@Service
public interface CustomerService {

    void addCustomer(Customer customer);

    Optional<Customer> getCustomerById(String id);
}
