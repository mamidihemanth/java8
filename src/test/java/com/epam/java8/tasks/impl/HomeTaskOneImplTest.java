package com.epam.java8.tasks.impl;


import com.epam.java8.model.Employee;
import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskOneImplTest {

    HomeTaskOneImpl homeTask;
    DataExtractor dataExtractor;

    @BeforeEach
     void  beforeAll() {
       homeTask = new HomeTaskOneImpl();
       dataExtractor = new DataExtractor();
    }


    @Test
    void checkStringIsPalindromeOrNotCrt() {
      boolean result1 =  homeTask.checkStringIsPalindromeOrNotWithLambdas(DataExtractor.getCrtPalindrome());
      boolean result2 = homeTask.checkStringIsPalindromeOrNot(DataExtractor.getCrtPalindrome());
      assertEquals(result1,result2);
    }

    @Test
    void checkStringIsPalindromeOrNotWrong() {
        boolean result1 =  homeTask.checkStringIsPalindromeOrNotWithLambdas(DataExtractor.getWrngPalindrome());
        boolean result2 =  homeTask.checkStringIsPalindromeOrNot(DataExtractor.getWrngPalindrome());
        assertEquals(result1,result2);
    }

    @Test
    void secondLargestNumber() {
       int result1 = homeTask.secondLargestNumberWithLambdas(dataExtractor.getNumbers());
       int result2 = homeTask.secondLargestNumber(dataExtractor.getNumbers());
       assertEquals(result1, result2);
    }

    @Test
    void checkStrsAreRotationOfEachOtherCrt() {
        boolean result1 = homeTask.checkStrsAreRotationOfEachOtherWithLambdas(DataExtractor.getROTATION(), DataExtractor.getLtRotation());
        boolean result2 = homeTask.checkStrsAreRotationOfEachOther(DataExtractor.getROTATION(), DataExtractor.getLtRotation());
        boolean result3 = homeTask.checkStrsAreRotationOfEachOtherWithLambdas(DataExtractor.getROTATION(),DataExtractor.getRtRotation());
        boolean result4 = homeTask.checkStrsAreRotationOfEachOther(DataExtractor.getROTATION(),DataExtractor.getRtRotation());
        assertEquals(result1, result2);
        assertEquals(result3, result4);
    }

    @Test
    void checkStrsAreRotationOfEachOtherWrng() {
        boolean result1 = homeTask.checkStrsAreRotationOfEachOtherWithLambdas(DataExtractor.getROTATION(), DataExtractor.getWrngPalindrome());
        boolean result2 = homeTask.checkStrsAreRotationOfEachOther(DataExtractor.getROTATION(), DataExtractor.getWrngPalindrome());
        assertEquals(result1,result2);
    }

    @Test
    void sortEmployeesByName() {
        List<Employee> employeeList1 = homeTask.sortEmployeesByNameWithLambdas(DataExtractor.getEmployeesList());
        List<Employee> employeeList2 = homeTask.sortEmployeesByName(DataExtractor.getEmployeesList());
        assertEquals(employeeList1.get(0).getName(), employeeList2.get(0).getName());
    }

    @Test
    void sortNumbers() {
       List<Integer> integerList1 = homeTask.sortNumbersWithLambdas(dataExtractor.getNumbers());
       List<Integer> integerList2 = homeTask.sortNumbers(dataExtractor.getNumbers());
       assertEquals(integerList1.get(0), integerList2.get(0));
    }

    @Test
    void treeSetSortNumbers() {
        TreeSet<Integer> integerList1 = homeTask.treeSetSortNumbersWithLambdas(dataExtractor.getNumbers());
        TreeSet<Integer> integerList2 = homeTask.treeSetSortNumbers(dataExtractor.getNumbers());
        assertEquals(integerList1.first(), integerList2.first());
    }

    @Test
    void treeSetSortEmployees() {
        TreeSet<Employee> integerList1 = homeTask.treeSetSortEmployeesWithLambdas(DataExtractor.getEmployeesList());
        TreeSet<Employee> integerList2 = homeTask.treeSetSortEmployees(DataExtractor.getEmployeesList());
        assertEquals(integerList1.first().getName(), integerList2.first().getName());
    }

    @Test
    void treeMapSortNumbersWithLambdas() {
        Map<Integer, Integer> integerMap1 = homeTask.treeMapSortNumbersWithLambdas(dataExtractor.getMapOfNumbers());
        Map<Integer, Integer> integerMap2 = homeTask.treeMapSortNumbers(dataExtractor.getMapOfNumbers());
        assertTrue(integerMap1.equals(integerMap2));
    }

    @Test
    void treeMapSortEmployees() {
        Map<Employee, Integer> integerMap1 = homeTask.treeMapSortEmployeesWithLambdas(dataExtractor.getMapOfEmployees());
        Map<Employee, Integer> integerMap2 = homeTask.treeMapSortEmployees(dataExtractor.getMapOfEmployees());
        assertTrue(integerMap1.equals(integerMap2));
    }

}