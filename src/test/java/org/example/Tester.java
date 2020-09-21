package org.example;

import org.example.application.population.Populator;
import org.example.application.util.PropertiesLoader;

public class Tester {

    public static void main(String[] args) throws Throwable {
        PropertiesLoader.loadProperties();
        new Populator().populateAll();
    }
}
