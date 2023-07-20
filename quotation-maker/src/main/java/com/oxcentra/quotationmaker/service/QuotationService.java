package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Quotation;

import java.util.Optional;

public interface QuotationService {
    void addQuotation(QuotationDataDto quotationDataDto);

    Integer getReferenceNumber();

    Optional<Quotation> getQuotationById(int referenceNumber);
}
