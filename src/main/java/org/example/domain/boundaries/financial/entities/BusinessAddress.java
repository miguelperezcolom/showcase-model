package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.Embeddable;

@Embeddable
public class BusinessAddress extends Address {

    String contactName;

}
