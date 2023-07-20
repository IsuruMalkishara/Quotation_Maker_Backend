package com.oxcentra.quotationmaker.dto;

import com.oxcentra.quotationmaker.model.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuotationDataDto {
    private int referenceNumber;
    private Customer customer;
    private Quotation quotation;
    private List<Product> products;
    private  List<MesurementTable> mesurementTables;
    private List<ProductItem> productItems;
}
