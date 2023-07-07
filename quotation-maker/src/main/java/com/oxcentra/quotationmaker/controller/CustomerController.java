package com.oxcentra.quotationmaker.controller;

import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reference")
    public @ResponseBody
    Integer getReferenceNumber(){
        return customerService.getReferenceNumber();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/customer")
    public @ResponseBody
    Boolean addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
