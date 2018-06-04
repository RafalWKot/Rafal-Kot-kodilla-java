package com.kodilla.good.patterns.challenges.distributionorderservice;

import java.util.Objects;

public class Product {
    private final String productName;
    private final double productPrize;
    private final Distributor distributor;

    public Product(String productName, double productPrize, Distributor distributor) {
        this.productName = productName;
        this.productPrize = productPrize;
        this.distributor = distributor;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrize() {
        return productPrize;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productPrize, productPrize) == 0 &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(distributor, product.distributor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productPrize, distributor);
    }
}
