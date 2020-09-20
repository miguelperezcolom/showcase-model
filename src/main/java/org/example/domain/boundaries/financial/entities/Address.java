package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    String street;

    String zipCode;

    String city;

    String state;

    String country;

}
