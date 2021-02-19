package com.epam.java8.ExerciseOne;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeTaskOne {

    StringBuilder builder;
    HomeTaskOne(String s) {
        builder = new StringBuilder(s);
    }

    public static void main(String args[]) {
        checkStringIsPalindromeOrNot();
        secondLargestNumber();
        checkStrsAreRotationOfEachOther();
        sortEmployeesByName(DataExtractor.getEmployeesList());
        treeSetExample();
        treeMapExample();
        collectionsSort(DataExtractor.getEmployeesList());
        threadExample(DataExtractor.getEmployeesList());
    }


    private static void checkStringIsPalindromeOrNot() {
        String s = "MALAYALAM";
        StringBuilder builder = Utils.getStringBuilder(s);
        Function<String,String> result = (s1) -> s1+" Given String is Palindrome";
        Consumer<String> print = s1 -> System.out.println(s1);
        Predicate<StringBuilder> checkPalindrome = (s1) -> s1.equals(Utils.reverseStringBuilder(s1));
        if(checkPalindrome.test(builder)) {
            print.accept(result.apply("YES"));
        } else {
            print.accept(result.apply("NO"));
        }
    }

    private static void secondLargestNumber() {
        Consumer<Integer> print = number -> System.out.println(number);
        Optional<Integer> number = Stream.of(1,2,3,4,5,6,7,8,9).sorted(Utils.comparatorFordecendingOrder())
                     .limit(2).sorted().findFirst();
        if(number.isPresent()) {
            print.accept(number.get());
        }
    }

    private static void checkStrsAreRotationOfEachOther() {
        String str = "abcdefgh";
        String rtRotation = "defghabc";
        String lftRotation = "fghabcde";
        String failedCase = "xyzopbp";
        BiPredicate<String,String> checkRotation = (str1, str2) -> Utils.appendString(str1).contains(str2);
        Consumer<Boolean> print = output -> System.out.println(output);
        print.accept(checkRotation.test(str,rtRotation));
        print.accept(checkRotation.test(str,lftRotation));
        print.accept(checkRotation.test(str,failedCase));
    }

    private static void sortEmployeesByName(Collection<? extends Employee> employeesList) {

        employeesList.stream()
                     .sorted(Utils.employeeComparatorAsc())
                     .forEach(System.out::println);

    }

    private static void treeSetExample() {
        TreeSet<Integer> numbers = new TreeSet<>(Utils.comparatorFordecendingOrder());
        numbers.addAll(Arrays.asList(1,3,5,2,6,0,9,1,7));
        numbers.forEach(System.out::println);

        TreeSet<Employee> employees = new TreeSet<>(Utils.employeeComparatorAsc());
        employees.addAll(DataExtractor.getEmployeesList());
        employees.forEach(System.out::println);
    }

    private static void treeMapExample() {
        Map<Integer,String> elements = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) {
                    return -1;
                } else if(o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });
        elements.putAll(DataExtractor.getEmployeesList()
                .stream()
                .collect(Collectors.toMap(Employee::getEmpNumber, Employee::getName)));

        elements.entrySet().stream().forEach(System.out::println);



        Map<Employee,Integer> employees = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        employees.putAll(DataExtractor.getEmployeesList()
                .stream()
                .collect(Collectors.toMap(Function.identity(), Employee::getEmpNumber)));

        employees.entrySet().stream().forEach(System.out::println);

    }

    private static void collectionsSort(List<Employee> employeesList) {
        Collections.sort(employeesList);
        employeesList.forEach(System.out::println);
    }

    private static void threadExample(List<Employee> employeesList) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                employeesList.forEach(System.out::println);
            }
        });
        thread.start();
    }
}
