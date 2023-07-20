package com.oxcentra.quotationmaker.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="rate")
    private float rate;

    @Column(name="qty")
    private float qty;

    @Column(name="value")
    private float value;

    @ManyToOne
    @JoinColumn(name="quotation_id")
    private Quotation quotation;

}
