package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskFourImplTest {

    DataExtractor dataExtractor;
    HomeTaskFourImpl homeTaskFour;

    @BeforeEach
    void beforeAll() {
        homeTaskFour = new HomeTaskFourImpl();
        dataExtractor = new DataExtractor();
    }

    @Test
    void updateGrade() {
        List<Product> products = homeTaskFour.updateGrade(DataExtractor.getProductList(), 1000);
        assertTrue(products.get(2).getGrade().equalsIgnoreCase("PREMIUM"));
    }

    @Test
    void updateName() {
        List<Product> products = homeTaskFour.updateName(DataExtractor.getProductList(), 3000);
        assertTrue(products.get(3).getName().endsWith("*"));
    }

    @Test
    void printNameWithSuffix() {
        List<Product> products = homeTaskFour.printNameWithSuffix(DataExtractor.getProductList(), 1000, 3000);
        assertTrue(products.get(3).getName().endsWith("*"));
    }

    @Test
    void otpGenerator() {
        String otp = homeTaskFour.otpGenerator();
        assertTrue(otp != null);
    }

    @Test
    void getRandomProduct() {
       Product product = homeTaskFour.getRandomProduct();
       assertTrue(product != null);
    }
}