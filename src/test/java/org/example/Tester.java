package org.example;

import org.example.population.Populator;

public class Tester {

    public static void main(String[] args) throws Throwable {
        PropertiesLoader.loadProperties();
        new Populator().populateAll();
    }
}
