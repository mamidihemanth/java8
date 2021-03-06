package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskFiveImplTest {

    DataExtractor dataExtractor;
    HomeTaskFiveImpl homeTaskFive;

    @BeforeEach
    void beforeAll() {
        homeTaskFive = new HomeTaskFiveImpl();
        dataExtractor = new DataExtractor();
    }

    @Test
    void createProduct() {
        Product product = homeTaskFive.getProduct("MOUSE", 700);
        assertTrue(product.getName().equalsIgnoreCase("mouse"));
    }

    @Test
    void calculateCost() {
        Integer cost = homeTaskFive.calculateCost(dataExtractor.getProductsWithQuantity());
        assertTrue(cost == 46000);
    }
}