package com.oxcentra.quotationmaker.model;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MesurementTable {
    private int id;
    private String type;
    private List<Measurement> table;
    private Double totalPcs;
    private Double totalSqFt;

}
