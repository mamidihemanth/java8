package com.epam.java8.tasks.impl;

import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskThreeImplTest {

    HomeTaskThreeImpl homeTaskThree;
    DataExtractor dataExtractor;

    @BeforeEach
    void beforeAll() {
        dataExtractor = new DataExtractor();
        homeTaskThree = new HomeTaskThreeImpl();
    }

    @Test
    void costOfAllProducts() {
        int cost = homeTaskThree.costOfAllProducts(DataExtractor.getProductList());
        assertTrue(cost == 16600);
    }

    @Test
    void costOfAllProductsWithPriceN() {
        int cost = homeTaskThree.costOfAllProductsWithPriceN(DataExtractor.getProductList(), 1000);
        assertTrue(cost == 13000);
    }

    @Test
    void costOfAllProductsWithCategoryS() {
        int cost = homeTaskThree.costOfAllProductsWithCategoryS(DataExtractor.getProductList(), "ELECTRICAL");
        assertTrue(cost == 8200);
    }

    @Test
    void costOfAllProductsWithPriceNCategoryS() {
        int cost = homeTaskThree.costOfAllProductsWithPriceNCategoryS(DataExtractor.getProductList(), 1000, "ELECTRICAL");
        assertTrue(cost == 7000);
    }
}