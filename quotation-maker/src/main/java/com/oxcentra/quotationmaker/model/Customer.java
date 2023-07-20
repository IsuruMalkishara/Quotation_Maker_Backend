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
@Table(name="customer")
public class Customer {


    @Column(name="name")
    private String name;

    @Column(name="organization")
    private String organization;

    @Column(name="position")
    private String position;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Id
    @Column(name="id")
    private String phone;


}
