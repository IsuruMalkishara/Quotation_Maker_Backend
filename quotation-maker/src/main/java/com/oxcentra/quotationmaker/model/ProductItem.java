package com.oxcentra.quotationmaker.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_item")
public class ProductItem {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="transmittance")
    private int transmittance;

    @Column(name="exterior")
    private int exterior;

    @Column(name="interior")
    private int interior;
}
