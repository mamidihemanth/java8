package com.epam.java8.utils;

@FunctionalInterface
public interface CustomPredicate<T,U,V> {
     boolean test(T t, U u, V v);
}
