package com.oxcentra.quotationmaker.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {
    private int id;
    private Double height;
    private Double width;
    private Double pcs;
    private Double sqFt;


}
