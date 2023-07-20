package com.oxcentra.quotationmaker.controller;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


}
