package org.example;

import io.mateu.mdd.util.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    public static void loadProperties() {
        System.out.println("Loading properties...");
        InputStream s = null;
        try {
            if (System.getProperty("appconf") != null) {
                System.out.println("Loading properties from file " + System.getProperty("appconf"));
                s = new FileInputStream(System.getProperty("appconf"));
            } else {
                s = Helper.class.getResourceAsStream("/appconf.properties");
                System.out.println("Loading properties classpath /appconf.properties");
            }

            if (s != null) {

                Properties p = new Properties();
                p.load(s);

                for (Map.Entry<Object, Object> e : p.entrySet()) {
                    if (System.getProperty("" + e.getKey()) == null) {
                        System.setProperty("" + e.getKey(), "" + e.getValue());
                    } else {
                    }
                }

                if (System.getProperty("javax.persistence.jdbc.url", "").contains("postgres")) {
                    System.setProperty("eclipselink.target-database", "io.mateu.mdd.se.postgresql.MiPostgreSQLPlatform");
                }
                s.close();
            } else {
                System.out.println("No appconf. Either set -Dappconf=xxxxxx.properties or place an appconf.properties file in your classpath.");
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
