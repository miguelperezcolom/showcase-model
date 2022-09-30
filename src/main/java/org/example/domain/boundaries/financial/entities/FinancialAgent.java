package org.example.domain.boundaries.financial.entities;

import io.mateu.mdd.shared.annotations.KPI;
import io.mateu.mdd.shared.annotations.Money;
import io.mateu.mdd.shared.annotations.TextArea;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class FinancialAgent {

    @Id
    @GeneratedValue
    private long id;

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
