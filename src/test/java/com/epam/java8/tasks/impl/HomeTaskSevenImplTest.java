package com.epam.java8.tasks.impl;

import com.epam.java8.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskSevenImplTest {

    HomeTaskSevenImpl homeTaskSeven = new HomeTaskSevenImpl();

    @Test
    void createEmployee() {
        Employee employee = homeTaskSeven.createEmployee(100, "Hemanth Kumar Mamidi", "CSE");
        assertTrue(employee.getEmpNumber()==100);
    }
}