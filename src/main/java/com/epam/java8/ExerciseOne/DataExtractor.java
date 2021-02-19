package com.epam.java8.ExerciseOne;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataExtractor {

    static List<Employee> getEmployeesList() {
        Employee b1 = new Employee(90021, "Amith",  "Java");
        Employee b2 = new Employee(90022, "Bhaskar", ".Net");
        Employee b3 = new Employee(90035, "Hemanth",  "Java");
        Employee b4 = new Employee(90029, "Prataph",  "Java");
        Employee b5 = new Employee(90025, "Brahma",  "QA");
        Employee b6 = new Employee(90031, "Kalyan",  "QA");
        Employee b7 = new Employee(90027, "Sai",  "Java");
        Employee b8 = new Employee(90082, "Mango",  "java");
        Employee b9 = new Employee(90092, "Surendra",  "R&D");
        Employee b10 = new Employee(90030, "Satya",  "R&D");

        return Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
    }
}
