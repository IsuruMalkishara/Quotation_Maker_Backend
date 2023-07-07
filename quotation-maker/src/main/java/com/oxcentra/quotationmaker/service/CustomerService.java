package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Integer getReferenceNumber();

    Boolean addCustomer(Customer customer);
}
