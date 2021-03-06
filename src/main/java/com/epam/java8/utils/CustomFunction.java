package com.epam.java8.utils;

import com.epam.java8.model.Employee;

@FunctionalInterface
public interface CustomFunction<T,U,V,R> {
    R getEmployee(T t, U u, V v);
}
