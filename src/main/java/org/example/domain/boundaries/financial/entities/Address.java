package org.example.domain.boundaries.financial.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable@Getter@Setter
public class Address {

    String street;

    String zipCode;

    String city;

    String state;

    String country;

}
