package org.example.application.population;


import io.mateu.util.Helper;
import io.mateu.util.persistence.JPAHelper;

import java.io.InputStream;

import static io.mateu.util.Helper.fromYaml;


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
