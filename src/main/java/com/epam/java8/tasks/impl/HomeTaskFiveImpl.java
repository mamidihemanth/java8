package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.tasks.HomeTask;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.logging.Logger;


public class HomeTaskFiveImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskFiveImpl.class.getName());

    private BiFunction<String, Integer, Product> createProduct =  HomeTaskFiveImpl::createProduct;
    private BiFunction<Product, Integer, Integer> calculateCost =  HomeTaskFiveImpl::calculate;
    private static BiFunction<Integer, Integer, Integer> productCost =  ((price, quantity) -> price*quantity);
//    private static BiFunction<Integer, Integer, Integer> productsCost =  ((productCost, sum) -> productCost+sum);

    Consumer<Product> print = (product -> LOGGER.info(product.toString()));
    Consumer<Integer> printCost = (cost -> LOGGER.info(String.valueOf(cost)));

    private static Integer calculate(Product product, Integer quantity) {
        return productCost.apply(product.getPrice(), quantity);
    }


    public static Product createProduct(String name, Integer price) {
        return new Product(name,price,"Electrical","Premium");
    }

    public Product getProduct(String name, Integer price) {
        Product product = createProduct.apply(name,price);
        print.accept(product);
        return product;
    }

    public Integer calculateCost(Map<Product, Integer> products) {
        int total = 0;
        for(Map.Entry<Product, Integer> element : products.entrySet()) {
            total += calculateCost.apply(element.getKey(), element.getValue());
//            total = productsCost.apply(eachProductCost, total);
        }
        printCost.accept(total);
        return total;
    }

    @Override
    public void driver() {

    }
}
