package com.epam.java8.tasks.impl;

import com.epam.java8.model.Employee;
import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.DataExtractor;
import com.epam.java8.utils.Utils;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HomeTaskOneImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskOneImpl.class.getName());

    
    public boolean checkStringIsPalindromeOrNotWithLambdas(String str) {
        StringBuilder builder = Utils.getStringBuilder(str);
        StringBuilder reverse = Utils.getStringBuilder(str);
        reverse.reverse();
        BiPredicate<String, String> checkPalindrome = (s1, s2) -> s1.equals(s2);
        if(checkPalindrome.test(builder.toString(), reverse.toString())) {
           return true;
        } else {
            return false;
        }
    }

    
    public Integer secondLargestNumberWithLambdas(List<Integer> numbers) {
        Optional<Integer> number = numbers.stream().sorted(Utils.comparatorFordecendingOrder())
                .limit(2).sorted().findFirst();
        if(number.isPresent()) {
            return number.get();
        }
        return -1;
    }

    
    public boolean checkStrsAreRotationOfEachOtherWithLambdas(String str1, String str2) {
        BiPredicate<String,String> checkRotation = (s1, s2) -> Utils.appendString(s1).contains(s2);
         return checkRotation.test(str1,str2);
    }

    
    public List<Employee> sortEmployeesByNameWithLambdas(List<Employee> employees) {
       return employees.stream()
                .sorted(Utils.employeeComparatorAsc())
                .collect(Collectors.toList());
    }

    
    public List<Integer> sortNumbersWithLambdas(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Utils.comparatorDesc())
                .collect(Collectors.toList());
    }

    
    public TreeSet<Integer> treeSetSortNumbersWithLambdas(List<Integer> list) {
        TreeSet<Integer> numbers = new TreeSet<>(Utils.comparatorFordecendingOrder());
        numbers.addAll(list);
        return numbers;
    }

    
    public TreeSet<Employee> treeSetSortEmployeesWithLambdas(List<Employee> list) {
        TreeSet<Employee> employees = new TreeSet<>(Utils.employeeComparatorAsc());
        employees.addAll(list);
        return employees;
    }

    
    public Map<Integer, Integer> treeMapSortNumbersWithLambdas(Map<Integer, Integer> numbers) {
        Map<Integer,Integer> elements = new TreeMap<>((o1,o2) -> o1>o2 ? -1 : o1==o2 ? 0 : 1);
        elements.putAll(numbers);
        return elements;
    }

    
    public Map<Employee, Integer> treeMapSortEmployeesWithLambdas(Map<Employee, Integer> employees) {
        Map<Employee,Integer> sortedEmployees = new TreeMap<>((o1,o2) -> o1.getName().compareTo(o2.getName()));
        sortedEmployees.putAll(employees);
        return sortedEmployees;
    }

    
    public void treeMapSortEmployees1WithLambdas(Map<Integer, Employee> employees) {
        Comparator<Map.Entry<Integer, Employee>> comparator = (o1, o2) -> o1.getValue().getName().compareTo(o2.getValue().getName());
        employees.entrySet().stream().sorted(comparator).forEach(employee -> LOGGER.info(employee.toString()));
    }

    
    public List<Employee> collectionsSortWithLambdas(List<Employee> employees) {
        Collections.sort(employees , Utils.employeeComparatorDesc());
        return employees;
    }

    
    public void threadExampleWithLambdas(List<Integer> numbers) {
        Thread thread = new Thread( () -> numbers.forEach( e -> LOGGER.info(e::toString)));
    }

    
    public boolean checkStringIsPalindromeOrNot(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
       stringBuilder =  stringBuilder.reverse();
       if(stringBuilder.toString().equals(str)) {
           return true;
       }
        return false;
    }

    
    public Integer secondLargestNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size()-2);
    }

    
    public boolean checkStrsAreRotationOfEachOther(String str1, String str2) {
        str1 = str1 + str1;
        if(str1.contains(str2)) {
            return true;
        }
        return false;
    }

    
    public List<Employee> sortEmployeesByName(List<Employee> employees) {
        Collections.sort(employees, Collections.reverseOrder());
        return employees;
    }

    
    public List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers, Collections.reverseOrder());
        return numbers;
    }

    
    public TreeSet<Integer> treeSetSortNumbers(List<Integer> numbers) {
        TreeSet<Integer> sortNumbers = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) {
                    return -1;
                } else if(o1<o2) {
                    return  1;
                } else {
                    return 0;
                }
            }
        });
        sortNumbers.addAll(numbers);
        return sortNumbers;
    }

    
    public TreeSet<Employee> treeSetSortEmployees(List<Employee> employees) {
        TreeSet<Employee> sortEmployes = new TreeSet<>(new Comparator<Employee>() {
            
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sortEmployes.addAll(employees);
        return sortEmployes;
    }

    
    public Map<Integer, Integer> treeMapSortNumbers(Map<Integer, Integer> numbers) {
        Map<Integer,Integer> sortNumbers = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) {
                    return -1;
                } else if(o1<o2) {
                    return  1;
                } else {
                    return 0;
                }
            }
        });
        sortNumbers.putAll(numbers);
        return sortNumbers;
    }

    
    public Map<Employee, Integer> treeMapSortEmployees(Map<Employee, Integer> employees) {
        Map<Employee, Integer> sortEmployees = new TreeMap<>(new Comparator<Employee>() {
            
            public int compare(Employee o1, Employee o2) {
               return o1.getName().compareTo(o2.getName());
            }
        });
        sortEmployees.putAll(employees);
        return sortEmployees;
    }

    
    public Map<Integer, Employee> treeMapSortEmployees1(Map<Integer, Employee> employees) {
        Comparator<Map.Entry<Integer,Employee>> comparator = new Comparator<Map.Entry<Integer, Employee>>() {
            
            public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        };
        Map<Integer, Employee> sortEmployees = new TreeMap<Integer,Employee>((Map<? extends Integer, ? extends Employee>) comparator);
        sortEmployees.putAll(employees);
        return sortEmployees;
    }

    
    public List<Employee> collectionsSort(List<Employee> employees) {
        Collections.sort(employees);
        return employees;
    }

    
    public void threadExample(List<Integer> numbers) {
        Runnable runnable = new Runnable() {
            
            public void run() {
                numbers.forEach(e -> LOGGER.info(String.valueOf(e)));
            }
        };
        new Thread(runnable).start();
    }

    @Override
    public void driver() {
        this.checkStringIsPalindromeOrNotWithLambdas(DataExtractor.getCrtPalindrome());
    }
}
