package com.epam.java8.utils;

import com.epam.java8.model.Employee;
import com.epam.java8.model.Product;
import com.epam.java8.model.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataExtractor {

      private static final String CRT_PALINDROME = "MALAYALAM";
      private static final String WRNG_PALINDROME = "HEMANTH";
      private static final String ROTATION = "HEMANTH";
      private static final String LT_ROTATION = "THHEMAN";
      private static final String RT_ROTATION = "MANTHHE";


    public static String getROTATION() {
        return ROTATION;
    }

    public static String getLtRotation() {
        return LT_ROTATION;
    }

    public static String getRtRotation() {
        return RT_ROTATION;
    }

    public static String getCrtPalindrome() {
          return CRT_PALINDROME;
     }

     public static String getWrngPalindrome() {
          return WRNG_PALINDROME;
     }

     public List<Integer> getNumbers() {
         return Arrays.asList(1,6,3,9,4,8,10,15,23,0,26);
     }

     public Map<Integer,Integer> getMapOfNumbers() {
        return getNumbers().stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue));
     }

    public Map<Employee,Integer> getMapOfEmployees() {
        return getEmployeesList().stream().collect(Collectors.toMap(Function.identity(), employee -> employee.getEmpNumber()));
    }

    public Map<Product, Integer> getProductsWithQuantity() {
        List<Product> products = getProductList();
        Map<Product, Integer> elements = products
                .stream()
                .collect(Collectors.toMap(Function.identity(), product -> product.getPrice()/1000));
        return elements;
    }

     public static List<Employee> getEmployeesList() {
        Employee b1 = new Employee(90021, "Amith",  "Java");
        Employee b2 = new Employee(90022, "Bhaskar", ".Net");
        Employee b3 = new Employee(90035, "Hemanth",  "Java");
        Employee b4 = new Employee(90029, "Prataph",  "Java");
        Employee b5 = new Employee(90025, "Brahma",  "QA");
        Employee b6 = new Employee(90031, "Kalyan",  "QA");
        Employee b7 = new Employee(90027, "Sai",  "Java");
        Employee b8 = new Employee(90082, "Mango",  "java");
        Employee b9 = new Employee(90092, "Surendra",  "R&D");
        Employee b10 = new Employee(90030, "Satya",  "R&D");

        return Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
    }

    public static List<Product> getProductList() {
        Product p1 = new Product("LIGHT", 1000, "ELECTRICAL", "A");
        Product p2 = new Product("FAN", 200, "ELECTRICAL", "A*");
        Product p3 = new Product("REFRIGERATOR", 3000, "ELECTRICAL", "PREMIUM");
        Product p4 = new Product("WASHING MACHINE", 4000, "ELECTRICAL", "PREMIUM");
        Product p5 = new Product("CAR", 1000, "MECHANICAL", "A");
        Product p6 = new Product("BIKE", 200, "MECHANICAL", "A*");
        Product p7 = new Product("CYCLE", 3000, "MECHANICAL", "PREMIUM");
        Product p8 = new Product("BOTTLE", 1000, "PLASTIC", "A");
        Product p9 = new Product("GLASS", 200, "PLASTIC", "A*");
        Product p10 = new Product("TOYS", 3000, "PLASTIC", "PREMIUM");

        return Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
    }

    public static List<Response<Employee>> getResponses() {
        List<Employee> employees = DataExtractor.getEmployeesList();
        Response<Employee> response1 = new Response<>(employees.get(0), 400, "JSON");
        Response<Employee> response2 = new Response<>(employees.get(1), 400, "JSON");
        Response<Employee> response3 = new Response<>(employees.get(2), 500, "JSON");
        Response<Employee> response4 = new Response<>(employees.get(3), 500, "XML");
        Response<Employee> response5 = new Response<>(employees.get(4), 404, "XML");
        Response<Employee> response6 = new Response<>(employees.get(5), 400, "PDF");
        Response<Employee> response7 = new Response<>(employees.get(6), 404, "JSON");

        return Arrays.asList(response1,response2,response3,response4,response7,response6,response5);
    }
}
