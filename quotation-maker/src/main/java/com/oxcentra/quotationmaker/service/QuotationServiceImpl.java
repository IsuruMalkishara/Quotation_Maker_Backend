package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.model.Quotation;
import com.oxcentra.quotationmaker.repository.QuotationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuotationServiceImpl implements QuotationService{
    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public void addQuotation(QuotationDataDto quotationDataDto) {

        Optional<Customer> customer=customerService.getCustomerById(quotationDataDto.getCustomer().getPhone());
        log.info(String.valueOf(customer));
        Quotation quotation=quotationDataDto.getQuotation();
        quotation.setCustomer(customer.get());
        quotationRepository.save(quotation);
        log.info("Added new quotation");
    }

    @Override
    public Integer getReferenceNumber() {
        Integer nextReferenceNumber;

        List<Quotation> allQuotations=quotationRepository.findAll();
        Integer numberOfQuotations=allQuotations.size();

        if(numberOfQuotations>0){
            Integer lastId=allQuotations.get(numberOfQuotations-1).getId();
            nextReferenceNumber=lastId+1;
        }else{
            nextReferenceNumber=1;
        }


        log.info("Next reference number: "+nextReferenceNumber);
        return nextReferenceNumber;
    }

    @Override
    public Optional<Quotation> getQuotationById(int referenceNumber) {
        return quotationRepository.findById(referenceNumber);
    }
}
