package com.epam.java8.driver;


import com.epam.java8.tasks.HomeTask;
import com.epam.java8.tasks.impl.*;

import java.util.Scanner;
import java.util.logging.Logger;

public class Driver {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    static HomeTask homeTask;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("ENTER THE TASK NO TO EXECUTE AS ONE OR TWO OR ...");
        int option = in.nextInt();
        Tasks task = Tasks.getTask(option);
        switch (task) {
            case ONE   : homeTask = new HomeTaskOneImpl();break;
            case TWO   : homeTask = new HomeTaskTwoImpl();break;
            case THREE : homeTask = new HomeTaskThreeImpl();break;
            case FOUR  : homeTask = new HomeTaskFourImpl();break;
            case FIVE  : homeTask = new HomeTaskFiveImpl();break;
            case SIX   : homeTask = new HomeTaskSixImpl();break;
            case SEVEN : homeTask = new HomeTaskSevenImpl();break;
            case EIGHT : homeTask = new HomeTaskEightImpl();break;
            default    : LOGGER.info("Enter the valid Number");
        }
        homeTask.driver();
    }
}
