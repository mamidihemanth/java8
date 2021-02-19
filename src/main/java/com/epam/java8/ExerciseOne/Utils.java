package com.epam.java8.ExerciseOne;

import java.util.Comparator;
import java.util.Map;

public interface Utils {

    static StringBuilder getStringBuilder(String s) {
        return new StringBuilder(s);
    }

    static StringBuilder reverseStringBuilder(StringBuilder s) {
        return s.reverse();
    }

    static String appendString(String str) {
        return str+str;
    }

    static Comparator<Integer> comparatorFordecendingOrder() {
        return (a, b) -> b.compareTo(a);
    }

    static Comparator<Employee> employeeComparatorAsc() {
        return (a, b) -> a.getName().compareTo(b.getName());
    }

    static Comparator<Employee> employeeComparatorDesc() {
        return (a, b) -> b.getName().compareTo(a.getName());
    }
}
