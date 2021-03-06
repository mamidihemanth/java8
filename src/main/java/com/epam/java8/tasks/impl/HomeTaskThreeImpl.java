package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.CustomPredicate;

import java.util.List;
import java.util.function.*;
import java.util.logging.Logger;

public class HomeTaskThreeImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskThreeImpl.class.getName());

    private Function<Product, Integer> getPrice = (product -> product.getPrice());
    private BiFunction<Product, Integer, Integer> calculateTwoNumbers = ((product, sum) -> getPrice.apply(product) + sum);
    private BiPredicate<Product, Integer> priceGraterThanN = (product,price) -> product.getPrice()>price;
    private BiPredicate<Product, String> isElectrical = (product,category) -> product.getCategory().equalsIgnoreCase(category);
    private CustomPredicate<Product, Integer, String> greterThanNCategory = ((product, price, category) -> product.getPrice()>price && product.getCategory().equalsIgnoreCase(category));
    private int sum =0 ;

    private Consumer<Integer> print  = (integer -> LOGGER.info(String.valueOf(integer)));

    public int costOfAllProducts(List<Product> products) {
        for (Product product : products) {
            sum = calculateTwoNumbers.apply(product,sum);
        }
        print.accept(sum);
        return sum;
    }

    public int costOfAllProductsWithPriceN(List<Product> products, Integer price) {
        for (Product product : products) {
            if(priceGraterThanN.test(product, price)) {
                sum = calculateTwoNumbers.apply(product,sum);
            }
        }
        print.accept(sum);
        return sum;
    }

    public int costOfAllProductsWithCategoryS(List<Product> products, String category) {
        for (Product product : products) {
            if(isElectrical.test(product, category)) {
                sum = calculateTwoNumbers.apply(product,sum);
            }
        }
        print.accept(sum);
        return sum;
    }

    public int costOfAllProductsWithPriceNCategoryS(List<Product> products, Integer price, String category) {
        for (Product product : products) {
            if(greterThanNCategory.test(product, price, category)) {
                sum = calculateTwoNumbers.apply(product,sum);
            }
        }
        print.accept(sum);
        return sum;
    }

    @Override
    public void driver() {

    }
}
