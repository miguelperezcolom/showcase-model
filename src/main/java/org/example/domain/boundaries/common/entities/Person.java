package org.example.domain.boundaries.common.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.mateu.mdd.core.annotations.Output;
import io.mateu.mdd.core.annotations.VisibleIf;
import lombok.MateuMDDEntity;
import org.example.domain.boundaries.financial.entities.FinancialAgent;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@MateuMDDEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public abstract class Person {

    @NotEmpty
    String name;

    @ManyToOne
    FinancialAgent financialAgent;

    LocalDate birthDate;

    @Output
    transient int age;

    public int getAge() {
        return (int) (birthDate != null?ChronoUnit.YEARS.between(birthDate, LocalDate.now()):0);
    }

    @VisibleIf("$this.isParentsAuthorizationRequired()")
    boolean parentsAuthorization;

    public boolean isParentsAuthorizationRequired() {
        return getAge() < 18;
    }

}
