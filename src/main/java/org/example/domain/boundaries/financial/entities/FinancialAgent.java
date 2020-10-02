package org.example.domain.boundaries.financial.entities;

import io.mateu.mdd.shared.annotations.KPI;
import io.mateu.mdd.shared.annotations.Money;
import io.mateu.mdd.shared.annotations.TextArea;
import lombok.MateuMDDEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@MateuMDDEntity
public class FinancialAgent {

    @NotEmpty
    String name;

    @ElementCollection
    @TextArea
    List<String> contactEmails;

    @Embedded
    Address address;


    @KPI@Money
    double balance;

}
