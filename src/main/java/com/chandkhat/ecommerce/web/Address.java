package com.chandkhat.ecommerce.web;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class Address {

     @Column(name = "address_1")
    private String address1;

     @Column(name = "address_2")
    private String address2;

     @Column
    private String city;

     @NotNull
     @Column(name = "postcode" , length = 10, nullable = false)
    private String postcode;

     @NotNull
    @Column(name = "country", length = 2, nullable = false)
    private String country;

}