package org.example.application.population;

import io.mateu.mdd.util.Helper;
import io.mateu.mdd.util.JPAHelper;

import java.io.InputStream;

public class Populator {

    public void populateAll() throws Throwable {

        JPAHelper.transact("showcase", em -> {

            InputStream r = Populator.class.getResourceAsStream("/data/initialdata.yaml");
            if (r != null) {
                InitialData data = Helper.fromYaml(Helper.leerFichero(r), InitialData.class);
                data.persistAll(em);
            }

        }, null);

    }

}
