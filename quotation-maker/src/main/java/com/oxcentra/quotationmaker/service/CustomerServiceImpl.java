package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {



    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void addCustomer(Customer customer) {
        log.info("customer name:"+customer.getName());
        Optional<Customer> customer1=getCustomerById(customer.getPhone());

        if(customer1.isPresent()){
            if(customer.getPosition().equals(null)){
                customer.setPosition(customer1.get().getPosition());
                if(customer.getOrganization().equals(null)){
                    customer.setOrganization(customer1.get().getOrganization());

                }
            } else{
                if(customer.getOrganization().equals(null)){
                    customer.setOrganization(customer1.get().getOrganization());

                }
            }

            customerRepository.save(customer);
            log.info("update");

        }else{
            customerRepository.save(customer);
            log.info("added new customer");
        }



    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        log.info("Finding customer of id "+id);
        Optional<Customer> customer=customerRepository.findById(id);


        return customer;
    }


}
