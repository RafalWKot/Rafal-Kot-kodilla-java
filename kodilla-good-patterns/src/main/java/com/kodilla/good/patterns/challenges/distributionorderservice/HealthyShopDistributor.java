package com.kodilla.good.patterns.challenges.distributionorderservice;

public class HealthyShopDistributor implements Distributor {
    @Override
    public boolean process() {
        System.out.println("HealthyShop is executing this order");
        return true;
    }
}
