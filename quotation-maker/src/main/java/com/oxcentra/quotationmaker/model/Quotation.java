package com.oxcentra.quotationmaker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="quotation")
public class Quotation {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="product_description")
    private String productDescription;



    @Column(name="total_qty")
    private float totalQty;

    @Column(name="grand")
    private float grand;

    @Column(name="advanced")
    private float advanced;

    @Column(name="balanced")
    private float balanced;

    @Column(name="date")
    private Date date;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

}
