package com.kodilla.good.patterns.challenges.productorderservice;

import java.util.Objects;

public class Product {
    private final String productName;
    private final double productPrice;

    public Product(String productName, double productPrize) {
        this.productName = productName;
        this.productPrice = productPrize;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productPrice, productPrice) == 0 &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productPrice);
    }
}
