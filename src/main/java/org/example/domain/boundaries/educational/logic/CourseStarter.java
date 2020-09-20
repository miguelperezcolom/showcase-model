package org.example.domain.boundaries.educational.logic;

import io.mateu.mdd.util.ddd.DDDContext;
import org.example.domain.boundaries.educational.entities.AcademicPlanRepository;

public class CourseStarter
        //implements DDDCommand
{

    //@Override
    public void run(DDDContext ctx) throws Throwable {
        AcademicPlanRepository repo = ctx.getRepo(AcademicPlanRepository.class);

        repo.findAll().stream().forEach(p -> {
            // close opened courses
            // create new course
        });
    }
}
