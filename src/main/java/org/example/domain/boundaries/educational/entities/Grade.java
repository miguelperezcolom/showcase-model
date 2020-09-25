package org.example.domain.boundaries.educational.entities;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import io.mateu.mdd.core.annotations.DependsOn;
import lombok.MateuMDDEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@MateuMDDEntity
public class Grade {

    @ManyToOne@NotNull
    private Teacher teacher;

    @ManyToOne@NotNull
    private Subject subject;

    transient private Classroom classroom;

    @ManyToOne@NotNull
    private Student student;

    @DependsOn("classroom")
    public DataProvider getStudentDataProvider() {
        return new ListDataProvider(classroom != null?classroom.students: List.of());
    }

    @NotNull@Enumerated(EnumType.STRING)
    private GradeValue value;

}
