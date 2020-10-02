package org.example.domain.boundaries.educational.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.mateu.mdd.shared.annotations.Ignored;
import io.mateu.util.persistence.JPAHelper;
import lombok.MateuMDDEntity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MateuMDDEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public class Course {

    String name;


    transient Map<Subject, Teacher> subjectResponsibles;

    @Ignored
    Map<Long, Long> _subjectResponsibles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    List<Semester> semesters;

    @OneToMany
    List<FinalGrade> finalGrades;


    @PrePersist@PreUpdate
    public void pre() {
        if (subjectResponsibles != null) {
            Map<Long, Long> m = new HashMap<>();
            for (Subject k : subjectResponsibles.keySet()) {
                m.put(k.getId(), subjectResponsibles.get(k) != null?subjectResponsibles.get(k).getId():null);
            }
            _subjectResponsibles = m;
        }
    }

    @PostLoad
    public void postLoad() {
        if (_subjectResponsibles != null) {
            Map<Subject, Teacher> m = new HashMap<>();
            for (Long k : _subjectResponsibles.keySet()) {
                m.put(JPAHelper.get(Subject.class, k), _subjectResponsibles.get(k) != null?JPAHelper.get(Teacher.class, _subjectResponsibles.get(k)):null);
            }
            subjectResponsibles = m;
        }
    }

}
