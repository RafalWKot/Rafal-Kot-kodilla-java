package com.kodilla.good.patterns.challenges.distributionorderservice;

public class GlutenFreeShopDistributor implements Distributor {
    @Override
    public boolean process() {
        System.out.println("GlutenFreeShop is executing this order");
        return true;
    }
}