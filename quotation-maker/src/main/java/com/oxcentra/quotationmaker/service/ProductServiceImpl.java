package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Product;
import com.oxcentra.quotationmaker.model.Quotation;
import com.oxcentra.quotationmaker.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private QuotationService quotationService;

    @Override
    public void addProductList(QuotationDataDto quotationDataDto) {

        Optional<Quotation> quotation=quotationService.getQuotationById(quotationDataDto.getReferenceNumber());

        for(int i=0;i<quotationDataDto.getProducts().size();i++){
            quotationDataDto.getProducts().get(i).setQuotation(quotation.get());
            productRepository.save(quotationDataDto.getProducts().get(i));
        }
       log.info("Added product list");
    }
}
