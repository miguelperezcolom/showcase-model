package org.example.application.population;

import io.mateu.mdd.util.Helper;
import io.mateu.mdd.util.JPAHelper;
import org.example.domain.boundaries.educational.entities.Classroom;
import org.example.domain.boundaries.educational.entities.Teacher;

import java.io.InputStream;

import static io.mateu.mdd.util.Helper.fromYaml;

public class Populator {

    public static void populateAll() throws Throwable {

        JPAHelper.transact("showcase", em -> {

            InputStream r = Populator.class.getResourceAsStream("/data/initialdata.yaml");
            if (r != null) {
                InitialData data = fromYaml(Helper.leerFichero(r), InitialData.class);
                data.persistAll(em);
            }

        }, null);


    }

}
