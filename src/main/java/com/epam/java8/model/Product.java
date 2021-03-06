package com.epam.java8.model;

public class Product {

    private String name;
    private Integer price;
    private String category;
    private String grade;

    public Product() {
    }

    public Product(String name, Integer price, String category, String grade) {
        this.name     = name;
        this.price    = price;
        this.category = category;
        this.grade    = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static Product toUpperCase(Product product) {
        product.getName().toUpperCase();
        return product;
    }
}
