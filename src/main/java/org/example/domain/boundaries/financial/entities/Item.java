package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.Id;

@MateuMDDEntity
public class Item {

    @Id
    String code;

    String description;

    double price;

}
