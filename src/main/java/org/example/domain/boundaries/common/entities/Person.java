package org.example.domain.boundaries.common.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vaadin.icons.VaadinIcons;
import io.mateu.mdd.shared.annotations.Action;
import io.mateu.mdd.shared.annotations.Output;
import io.mateu.mdd.shared.annotations.TextArea;
import io.mateu.mdd.shared.annotations.VisibleIf;
import io.mateu.util.notification.Notifier;
import lombok.MateuMDDEntity;
import org.example.domain.boundaries.financial.entities.FinancialAgent;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Collectors;

@MateuMDDEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public abstract class Person {

    @NotEmpty
    String name;

    String nationality;

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


    @Action(icon = VaadinIcons.ENVELOPE, order = 10)
    public static void sendEmail(Set<Person> selection, @NotEmpty String subject, @NotEmpty @TextArea String text) {
        Notifier.info("Email sent with subject = \"" + subject + "\" and text = \"" + text + "\" sent to " + selection.stream().map(p -> p.getName()).collect(Collectors.joining(",")) + "");
    }

    @Action(icon = VaadinIcons.ENVELOPE, order = 10)
    public void sendEmail(@NotEmpty String subject, @NotEmpty @TextArea String text) {
        Notifier.info("Email sent with subject = \"" + subject + "\" and text = \"" + text + "\"");
    }

    @Action(icon = VaadinIcons.CLOCK, order = 20)
    public String showLastAccess() {
        return LocalDateTime.now().toString();
    }

}
