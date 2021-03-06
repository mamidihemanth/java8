package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskEightImplTest {


    HomeTaskEightImpl homeTaskEight ;

    @BeforeEach
    void beforeAll() {
        homeTaskEight = new HomeTaskEightImpl();
    }

    @Test
    void getProductsGraterThanN() {
        List<Product> productsGraterThanN = homeTaskEight.getProductsGraterThanN(DataExtractor.getProductList(), 1000);
        assertTrue(productsGraterThanN.size()==4);
    }

    @Test
    void getProductsOfS() {
        List<Product> electricalProducts = homeTaskEight.getProductsOfS(DataExtractor.getProductList(), "ELECTRICAL");
        assertTrue(4 == electricalProducts.size());
    }

    @Test
    void getProductsWithPriceNCategoryS() {
        List<Product> electricalProducts = homeTaskEight.getProductsWithPriceNCategoryS(DataExtractor.getProductList(), 1000,"ELECTRICAL");
        assertTrue(2 == electricalProducts.size());
    }

    @Test
    void countProductsWithCategoryS() {
        int electricalProductsCount = homeTaskEight.countProductsWithCategoryS(DataExtractor.getProductList(), "ELECTRICAL");
        assertFalse(electricalProductsCount != 4);

    }
}