package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.MesurementTable;

import java.util.List;

public interface MeasurementTableService {
    List<MesurementTable> covertTableToDisplayableStructure(List<MesurementTable> mesurementTables);
}
