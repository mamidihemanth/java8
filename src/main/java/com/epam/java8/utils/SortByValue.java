package com.epam.java8.utils;

import com.epam.java8.model.Employee;

import java.util.Comparator;
import java.util.Map;

public class SortByValue implements Comparator<Map.Entry<Integer, Employee>> {
    @Override
    public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
        return o1.getValue().getName().compareTo(o2.getValue().getName());
    }
}
