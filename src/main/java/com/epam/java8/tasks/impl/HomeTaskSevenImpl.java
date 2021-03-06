package com.epam.java8.tasks.impl;

import com.epam.java8.model.Employee;
import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.CustomFunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class HomeTaskSevenImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskSevenImpl.class.getName());

    private CustomFunction<Integer, String, String, Employee> employee = Employee::new;
    private Consumer<Employee> print = (employee1 -> LOGGER.info(employee1.toString()));

    public Employee createEmployee(Integer empNo, String name, String department) {
        Employee employ = employee.getEmployee(empNo,name,department);
        print.accept(employ);
        return employ;
    }

    @Override
    public void driver() {

    }
}
