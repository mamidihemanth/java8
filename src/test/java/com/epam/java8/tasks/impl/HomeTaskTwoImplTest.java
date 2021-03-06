package com.epam.java8.tasks.impl;

import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskTwoImplTest {

    DataExtractor dataExtractor ;
    HomeTaskTwoImpl homeTask;

    @BeforeEach
    void beforeAll() {
        dataExtractor = new DataExtractor();
        homeTask = new HomeTaskTwoImpl();
    }

    @Test
    void getProductsGraterThanN() {
        int count = homeTask.getProductsGraterThanN(DataExtractor.getProductList(), 1000).size();
        assertTrue(count==4);
    }

    @Test
    void getProductsWithCategoryElectronics() {
        int count = homeTask.getProductsWithCategoryElectronics(DataExtractor.getProductList(), "ELECTRICAL").size();
        assertTrue(count==4);
    }

    @Test
    void getProductsGraterThanN_And_CategoryElectronics() {
        int count = homeTask.getProductsGraterThanN_And_CategoryElectronics(DataExtractor.getProductList()).size();
        assertTrue(count==2);
    }

    @Test
    void getProductsGraterThanN_OR_CategoryElectronics() {
        int count = homeTask.getProductsGraterThanN_OR_CategoryElectronics(DataExtractor.getProductList()).size();
        assertTrue(count==6);
    }

    @Test
    void getProductsLessThanN_And_CategoryElectronics() {
        int count = homeTask.getProductsLessThanN_And_CategoryElectronics(DataExtractor.getProductList()).size();
        assertTrue(count==1);
    }

    @Test
    void getResponsesWithStatusCodeN() {
        int count = homeTask.getResponsesWithStatusCodeN(DataExtractor.getResponses(),400).size();
        assertTrue(count==3);
    }

    @Test
    void getResponsesWithResponseTypeS() {
        int count = homeTask.getResponsesWithResponseTypeS(DataExtractor.getResponses(),"JSON").size();
        assertTrue(count==4);
    }

    @Test
    void getResponsesWithStatusCodeNResponseTypeS() {
        int count = homeTask.getResponsesWithStatusCodeNResponseTypeS(DataExtractor.getResponses()).size();
        assertTrue(count==2);
    }

    @Test
    void getResponsesWithStatusCodeOrResponseTypeS() {
        int count = homeTask.getResponsesWithStatusCodeOrResponseTypeS(DataExtractor.getResponses()).size();
        assertTrue(count==5);
    }

    @Test
    void getResponsesWithNotStatusCodeNResponseTypeS() {
        int count = homeTask.getResponsesWithNotStatusCodeNResponseTypeS(DataExtractor.getResponses()).size();
        assertTrue(count==2);
    }

    @Test
    void graterThanNOrEqualcategory() {
        int count = homeTask.graterThanNOrEqualcategory(DataExtractor.getProductList(), 1000, "ELECTRICAL").size();
        assertTrue(count==6);
    }

    @Test
    void testGraterThanNEqualcategory() {
        int count = homeTask.graterThanNEqualcategory(DataExtractor.getProductList(), 1000, "ELECTRICAL").size();
        assertTrue(count==2);
    }

    @Test
    void statusCodeAndResponseType() {
        int count = homeTask.statusCodeAndResponseType(DataExtractor.getResponses(), 400, "JSON").size();
        assertTrue(count==2);
    }

    @Test
    void statusCodeORResponseType() {
        int count = homeTask.statusCodeORResponseType(DataExtractor.getResponses(), 400, "JSON").size();
        assertTrue(count==5);
    }
}