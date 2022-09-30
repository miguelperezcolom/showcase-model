package org.example.domain.boundaries.educational.entities;

import com.google.common.collect.Lists;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import io.mateu.mdd.shared.annotations.DependsOn;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Grade {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne@NotNull
    private Teacher teacher;

    @ManyToOne@NotNull
    private Subject subject;

    transient private Classroom classroom;

    @ManyToOne@NotNull
    private Student student;

    @DependsOn("classroom")
    public DataProvider getStudentDataProvider() {
        return new ListDataProvider(classroom != null?classroom.students: Lists.newArrayList());
    }

    @NotNull@Enumerated(EnumType.STRING)
    private GradeValue value;

}
