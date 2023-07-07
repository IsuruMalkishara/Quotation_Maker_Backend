package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Integer getReferenceNumber() {
        Integer nextReferenceNumber;

        List<Customer> allCustomers=customerRepository.findAll();
        Integer numberOfCustomers=allCustomers.size();

        if(numberOfCustomers>0){
            Integer lastId=allCustomers.get(numberOfCustomers-1).getId();
            nextReferenceNumber=lastId+1;
        }else{
            nextReferenceNumber=1;
        }




        log.info("Next reference number: "+nextReferenceNumber);
        return nextReferenceNumber;
    }

    @Override
    public Boolean addCustomer(Customer customer) {
        log.info("New customer :"+customer.getName());
        customerRepository.save(customer);
        return true;
    }
}
