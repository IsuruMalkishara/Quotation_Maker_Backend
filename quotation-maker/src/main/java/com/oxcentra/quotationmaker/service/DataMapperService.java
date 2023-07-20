package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.model.MesurementTable;
import com.oxcentra.quotationmaker.model.ProductItem;
import org.thymeleaf.context.Context;

import java.util.List;

public interface DataMapperService {
    Context setFirstPageData(QuotationDataDto quotationDataDto);

    Context setSecondPageData(List<MesurementTable> mesurementTables);

    Context setThirdPageData(QuotationDataDto quotationDataDto);
}
