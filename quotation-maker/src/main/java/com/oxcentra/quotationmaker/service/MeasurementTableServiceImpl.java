package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.Measurement;
import com.oxcentra.quotationmaker.model.MesurementTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MeasurementTableServiceImpl implements MeasurementTableService{
    @Override
    public List<MesurementTable> covertTableToDisplayableStructure(List<MesurementTable> mesurementTables) {
      List<MesurementTable> mesurementTableList=new ArrayList<>();


        List<Measurement> measurementList=new ArrayList<>();
        int tableId=0;
       for(int i=0;i<mesurementTables.size();i++){
           MesurementTable mesurementTable=new MesurementTable();


           for(int j=0;j<mesurementTables.get(i).getTable().size();j++){
               Measurement measurement=new Measurement();
               Measurement measurement1=mesurementTables.get(i).getTable().get(j);
               measurement.setId(measurement1.getId());
               measurement.setHeight(measurement1.getHeight() != null ? measurement1.getHeight() : 0);
               measurement.setWidth(measurement1.getWidth() != null ? measurement1.getWidth() : 0);
               measurement.setPcs(measurement1.getPcs() != null ? measurement1.getPcs() : 0);
               measurement.setSqFt(measurement1.getSqFt() != null ? measurement1.getSqFt() : 0);


               measurementList.add(measurement);

               if(measurementList.size()==10 && j+1==mesurementTables.get(i).getTable().size()){
                   mesurementTable.setId(tableId);
                   tableId++;
                   mesurementTable.setTable(measurementList);
                   mesurementTable.setTotalPcs(mesurementTables.get(i).getTotalPcs());
                   mesurementTable.setTotalSqFt(mesurementTables.get(i).getTotalSqFt());
                   if(j<10){
                       mesurementTable.setType(mesurementTables.get(i).getType());
                   }else{
                       mesurementTable.setType(mesurementTables.get(i).getType()+" -Continue");
                   }

                   mesurementTableList.add(mesurementTable);
                  // measurementList.clear();
                   measurementList=new ArrayList<>();
                   mesurementTable=new MesurementTable();
               }else if(measurementList.size()==10 && j+1!=mesurementTables.get(i).getTable().size()){
                   mesurementTable.setId(tableId);
                   tableId++;
                   mesurementTable.setTable(measurementList);
                   if(j<10){
                       log.info(mesurementTables.get(i).getType());
                       mesurementTable.setType(mesurementTables.get(i).getType());
                   }else{
                       mesurementTable.setType(mesurementTables.get(i).getType()+" -Continue");
                   }

                   mesurementTableList.add(mesurementTable);
                   //measurementList.clear();
                   measurementList=new ArrayList<>();
                   mesurementTable=new MesurementTable();
                   log.info(String.valueOf(mesurementTableList.get(0).getTable()));
               }else if(j+1==mesurementTables.get(i).getTable().size()){
                   mesurementTable.setId(tableId);
                   tableId++;
                   mesurementTable.setTable(measurementList);
                   mesurementTable.setTotalPcs(mesurementTables.get(i).getTotalPcs());
                   mesurementTable.setTotalSqFt(mesurementTables.get(i).getTotalSqFt());
                   if(j<10){
                       mesurementTable.setType(mesurementTables.get(i).getType());
                   }else{
                       mesurementTable.setType(mesurementTables.get(i).getType()+" -Continue");
                   }

                   mesurementTableList.add(mesurementTable);
                   // measurementList.clear();
                   measurementList=new ArrayList<>();
                   mesurementTable=new MesurementTable();
               }
           }

       }
       log.info(String.valueOf(mesurementTableList));
        return mesurementTableList;
    }
}
