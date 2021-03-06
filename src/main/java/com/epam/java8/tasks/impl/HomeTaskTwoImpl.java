package com.epam.java8.tasks.impl;

import com.epam.java8.model.Employee;
import com.epam.java8.model.Product;
import com.epam.java8.model.Response;
import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.CustomPredicate;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class HomeTaskTwoImpl implements HomeTask {

   private  static final Logger LOGGER = Logger.getLogger(HomeTaskTwoImpl.class.getName());


   private static final Predicate<Product> graterThan   = (product) -> product.getPrice()>1000;
   private static final Predicate<Product> lessThan   = (product) -> product.getPrice()<1000;
   private static final Predicate<Product> checkCategory = (product) -> product.getCategory().equalsIgnoreCase("ELECTRICAL");
   private static final Predicate<Response<Employee>> checkStatusCode = ((response) -> response.getStatusCode() == 400);
   private static final Predicate<Response<Employee>> checkResponseType = ((response) -> response.getResponseType().equals("JSON"));

   private static final BiPredicate<Product, Integer> graterThanN = ((product, number) -> product.getPrice()>number);
   private static final BiPredicate<Product, String> checkCategoryS = ((product, category) -> product.getCategory().equalsIgnoreCase(category));
   private static final BiPredicate<Response<Employee>, Integer> checkStatusCodeWithN = ((response, number) -> response.getStatusCode() == number.intValue());
   private static final BiPredicate<Response<Employee>, String> checkResponseTypeWithS = ((response, responseType) -> response.getResponseType().equals(responseType));



   private static final CustomPredicate<Product,Integer,String> graterThanNEqualcategory =
           ((product, number, category) -> product.getPrice()>number && product.getCategory().equalsIgnoreCase(category));
   private static final CustomPredicate<Product,Integer,String> graterThanNOrEqualcategory =
           ((product, number, category) -> product.getPrice()>number || product.getCategory().equalsIgnoreCase(category));
   private static final CustomPredicate<Response<Employee>,Integer,String> statusCodeAndResponseType =
           ((response, number, responseType) -> response.getStatusCode() == number.intValue() && response.getResponseType().equalsIgnoreCase(responseType));
   private static final CustomPredicate<Response<Employee>,Integer,String> statusCodeORResponseType =
           ((response, number, responseType) -> response.getStatusCode() == number.intValue() || response.getResponseType().equalsIgnoreCase(responseType));

   private static final Consumer<List<Product>> printProduct = e -> e.forEach(product -> LOGGER.info(product.toString()));
   private static final Consumer<List<Response<Employee>>> printResponse = e -> e.forEach(response -> LOGGER.info(response.toString()));

   List<Product> resultList = new ArrayList<>();
   List<Response<Employee>> responseList = new ArrayList<>();


   public List<Product> getProductsGraterThanN(List<Product> products, Integer number) {
      for (Product product : products) {
         if(graterThanN.test(product,number)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Product> getProductsWithCategoryElectronics(List<Product> products, String category) {
      for (Product product : products) {
         if(checkCategoryS.test(product, category)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Product> getProductsGraterThanN_And_CategoryElectronics(List<Product> products) {
      for (Product product : products) {
         if(graterThan.and(checkCategory).test(product)) {
           resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Product> getProductsGraterThanN_OR_CategoryElectronics(List<Product> products) {
      for (Product product : products) {
         if(graterThan.or(checkCategory).test(product)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Product> getProductsLessThanN_And_CategoryElectronics(List<Product> products) {
      for (Product product : products) {
         if((lessThan.and(checkCategory)).test(product)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Response<Employee>> getResponsesWithStatusCodeN(List<Response<Employee>> responses, Integer statusCode) {
      for (Response<Employee> response : responses) {
         if(checkStatusCodeWithN.test(response, statusCode)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   public List<Response<Employee>> getResponsesWithResponseTypeS(List<Response<Employee>> responses, String responseType) {
      for (Response<Employee> response : responses) {
         if(checkResponseTypeWithS.test(response, responseType)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   public List<Response<Employee>> getResponsesWithStatusCodeNResponseTypeS(List<Response<Employee>> responses) {
      for (Response<Employee> response : responses) {
         if(checkStatusCode.and(checkResponseType).test(response)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   public List<Response<Employee>> getResponsesWithStatusCodeOrResponseTypeS(List<Response<Employee>> responses) {
      for (Response<Employee> response : responses) {
         if(checkStatusCode.or(checkResponseType).test(response)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   public List<Response<Employee>> getResponsesWithNotStatusCodeNResponseTypeS(List<Response<Employee>> responses) {
      for (Response<Employee> response : responses) {
         if(checkStatusCode.negate().and(checkResponseType).test(response)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   /*   With Custom Implementations
    */

   public List<Product> graterThanNOrEqualcategory(List<Product> products, Integer price, String category) {
      for (Product product : products) {
         if(graterThanNOrEqualcategory.test(product,price,category)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Product> graterThanNEqualcategory(List<Product> products, Integer price, String category) {
      for (Product product : products) {
         if(graterThanNEqualcategory.test(product, price, category)) {
            resultList.add(product);
         }
      }
      printProduct.accept(resultList);
      return resultList;
   }

   public List<Response<Employee>> statusCodeAndResponseType(List<Response<Employee>> responses, Integer statusCode, String responseType) {
      for (Response<Employee> response : responses) {
         if(statusCodeAndResponseType.test(response, statusCode, responseType)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   public List<Response<Employee>> statusCodeORResponseType(List<Response<Employee>> responses, Integer statusCode, String responseType) {
      for (Response<Employee> response : responses) {
         if(statusCodeORResponseType.test(response, statusCode, responseType)) {
            responseList.add(response);
         }
      }
      printResponse.accept(responseList);
      return responseList;
   }

   @Override
   public void driver() {

   }
}
