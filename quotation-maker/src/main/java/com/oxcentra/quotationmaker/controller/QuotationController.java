package com.oxcentra.quotationmaker.controller;

import com.itextpdf.text.DocumentException;
import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.MesurementTable;
import com.oxcentra.quotationmaker.model.ProductItem;
import com.oxcentra.quotationmaker.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@RestController
public class QuotationController {
    @Autowired
    private QuotationService quotationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @Autowired
    private DataMapperService dataMapperService;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private MeasurementTableService measurementTableService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reference")
    public @ResponseBody
    Integer getReferenceNumber(){
        return quotationService.getReferenceNumber();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/quotation")
    public @ResponseBody
    String addQuotationAndGenarateQuotationPagePdf(@RequestBody QuotationDataDto quotationDataDto) throws DocumentException, IOException {

        log.info(String.valueOf(quotationDataDto.getProducts()));

        log.info("length "+quotationDataDto.getMesurementTables().size());


        //save customer data in db
        customerService.addCustomer(quotationDataDto.getCustomer());

        //save quotation
        quotationService.addQuotation(quotationDataDto);

        //save product
        productService.addProductList(quotationDataDto);


        //generate pdf first page
        String finalHtml = null;

        Context dataContext = dataMapperService.setFirstPageData(quotationDataDto);
        log.info(String.valueOf(dataContext));

        finalHtml = springTemplateEngine.process("QuotationPage", dataContext);

        byte[] firstPage=pdfGeneratorService.htmlToPdf(finalHtml);

        List<MesurementTable> mesurementTables=measurementTableService.covertTableToDisplayableStructure(quotationDataDto.getMesurementTables());

        //generate pdf second page
        String finalHtml2 = null;

        Context dataContext2 = dataMapperService.setSecondPageData(mesurementTables);
        log.info(String.valueOf(dataContext));

        finalHtml2 = springTemplateEngine.process("MeasurementTable", dataContext2);

        byte[] secondPage=pdfGeneratorService.htmlToPdf(finalHtml2);

        //generate pdf 3rd page
        String finalHtml3 = null;


        Context dataContext3 = dataMapperService.setThirdPageData(quotationDataDto);
        log.info(String.valueOf(dataContext));

        finalHtml3 = springTemplateEngine.process("SciencetificData", dataContext3);

        byte[] thirdPage=pdfGeneratorService.htmlToPdf(finalHtml3);

        // Combine the PDFs into a single PDF
        List<byte[]> pdfs = new ArrayList<>();
        pdfs.add(firstPage);
        pdfs.add(secondPage);
        pdfs.add(thirdPage);
        byte[] combinedPdf = pdfGeneratorService.combinePdfFiles(pdfs);

        return Base64.getEncoder().encodeToString(combinedPdf);
    }
}
