package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.core.annotations.Repository;
import io.mateu.mdd.core.interfaces.IRepository;

@Repository
public interface CourseRepository extends IRepository<Course, Long> {
}
