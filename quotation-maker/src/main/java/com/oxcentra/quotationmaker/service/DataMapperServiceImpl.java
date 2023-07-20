package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.dto.QuotationDataDto;
import com.oxcentra.quotationmaker.model.Customer;
import com.oxcentra.quotationmaker.model.MesurementTable;
import com.oxcentra.quotationmaker.model.ProductItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DataMapperServiceImpl implements DataMapperService{
    @Override
    public Context setFirstPageData(QuotationDataDto quotationDataDto) {
        log.info("customer name: "+quotationDataDto.getCustomer().getName());
        Context context = new Context();

        Map<String, Object> data = new HashMap<>();

        data.put("quotationData", quotationDataDto);

        context.setVariables(data);

        return context;
    }

    @Override
    public Context setSecondPageData(List<MesurementTable> mesurementTables) {

        int numOfGroups = (int) Math.ceil(mesurementTables.size() / (double) 3);

        List<MesurementTable>[] tables = new ArrayList[numOfGroups];
       List<MesurementTable> mesurementTableList=new ArrayList<>();
       int rowId=0;

       for(int i=0;i<mesurementTables.size();i++){
           mesurementTableList.add(mesurementTables.get(i));
           if(mesurementTableList.size()==3 ||i==mesurementTables.size()-1){
               tables[rowId]=mesurementTableList;
               rowId++;
               mesurementTableList=new ArrayList<>();
           }
       }

        Context context = new Context();

        Map<String, Object> data = new HashMap<>();

        data.put("measurementTables", tables);

        context.setVariables(data);

        return context;
    }

    @Override
    public Context setThirdPageData(QuotationDataDto quotationDataDto) {

        Context context = new Context();

        Map<String, Object> data = new HashMap<>();

        data.put("products", quotationDataDto.getProductItems());

        context.setVariables(data);

        return context;
    }
}
