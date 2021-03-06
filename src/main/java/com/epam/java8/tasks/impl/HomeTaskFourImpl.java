package com.epam.java8.tasks.impl;

import com.epam.java8.model.Product;
import com.epam.java8.tasks.HomeTask;
import com.epam.java8.utils.DataExtractor;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.logging.Logger;

public class HomeTaskFourImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskFourImpl.class.getName());

    private BiPredicate<Product, Integer> checkPrice = ((product, integer) -> product.getPrice()>integer);
    private Predicate<Product> checkSuffix = (product -> product.getName().charAt(product.getName().length()-1) == '*');
    private Predicate<Product> checkGrade = (product -> product.getGrade().equalsIgnoreCase("PREMIUM"));


    private Consumer<Product>       updateGrade   = ((product) -> product.setGrade("PREMIUM"));
    private Consumer<Product>       updateName   = ((product) -> product.setName(product.getName()+"*"));
    private Consumer<Product> printProduct = (product -> LOGGER.info(product.toString()));
    private Consumer<String> printOtp = (otp -> LOGGER.info(otp));



    private Supplier<String> otp = () -> new DecimalFormat("0000").format(new Random().nextInt(9999));

    private Supplier<Product> supplyProduct  =  HomeTaskFourImpl::getProduct;


    static List<Product> products = DataExtractor.getProductList();

    public static Product getProduct() {
        Random randomNumber = new Random(0);
        return products.get(randomNumber.nextInt(products.size()));
    }



    public List<Product> updateGrade(List<Product> products, Integer price) {
        for (Product product : products) {
            if(checkPrice.test(product,price)) {
                updateGrade.andThen(printProduct).accept(product);
            }
        }
        return products;
    }

    public List<Product> updateName(List<Product> products, Integer price) {
        for (Product product : products) {
            if(checkPrice.test(product,price)) {
                updateName.andThen(printProduct).accept(product);
            }
        }
        return products;
    }

    public List<Product> printNameWithSuffix(List<Product> products, Integer priceForPremium, Integer priceForSuffix) {
        for (Product product : products) {
            if(checkPrice.test(product, priceForPremium)) {
                updateGrade.accept(product);
                if(checkPrice.test(product, priceForSuffix)) {
                    updateName.andThen(printProduct).accept(product);
                }
            }
        }
        return products;
    }

    public String otpGenerator() {
        String result = otp.get();
        printOtp.accept(result);
        return result;
    }

    public Product getRandomProduct() {
        Product product = supplyProduct.get();
        printProduct.accept(product);
        return product;
    }

    @Override
    public void driver() {

    }
}
