package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Product;

import java.util.List;

public interface ProductService {
    void addProductList(QuotationDataDto quotationDataDto);
}
