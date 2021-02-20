package com.epam.java8.ExerciseOne;

public class Driver {

    public static void main(String args[]) {
           HomeTaskOne taskOne = new HomeTaskOneImpl();
           taskOne.checkStringIsPalindromeOrNot();
           taskOne.checkStrsAreRotationOfEachOther();
           taskOne.collectionsSort();
           taskOne.secondLargestNumber();
           taskOne.sortEmployeesByName();
           taskOne.threadExample();
           taskOne.treeMapExample();
           taskOne.treeSetExample();
    }
}
