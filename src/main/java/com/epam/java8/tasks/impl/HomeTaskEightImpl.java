package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.tasks.HomeTask;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HomeTaskEightImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskEightImpl.class.getName());
    Consumer<List<Product>> print = (products -> products.forEach(product -> LOGGER.info(product.toString())));

    public List<Product> getProductsGraterThanN(List<Product> products, Integer price) {
        List<Product> collect = products
                .stream()
                .filter(product -> product.getPrice() > price)
                .collect(Collectors.toList());
        print.accept(collect);
        return collect;

    }

    public List<Product> getProductsOfS(List<Product> products, String category) {
        List<Product> collect = products
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        print.accept(collect);
        return collect;
    }

    public List<Product> getProductsWithPriceNCategoryS(List<Product> products, Integer price, String category) {
        List<Product> collect = products
                .stream()
                .filter(product -> product.getPrice() > price)
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .map(Product::toUpperCase)
                .collect(Collectors.toList());
        print.accept(collect);
        return collect;
    }

    public int countProductsWithCategoryS(List<Product> products, String category) {
        int count = (int) products
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .count();
        LOGGER.info(String.valueOf(count));
        return count;
    }

    @Override
    public void driver() {

    }
}
