package com.epam.java8.tasks.impl;

import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskSixImplTest {

    HomeTaskSixImpl homeTaskSix;
    DataExtractor dataExtractor;

    @BeforeEach
    void beforeAll() {
        dataExtractor = new DataExtractor();
        homeTaskSix = new HomeTaskSixImpl();
    }

    @Test
    void isPrime() {
        boolean prime = homeTaskSix.isPrime(7);
        assertTrue(prime);
        prime = homeTaskSix.isPrime(4);
        assertFalse(prime);
    }

    @Test
    void printSqureOfNumber() {
        boolean result = homeTaskSix.printSqureOfNumber(6);
        assertTrue(result);
    }

    @Test
    void getRandomNumber() {
        int number = homeTaskSix.getRandomNumber();
        assertTrue(number<5000);
    }
}