package com.kodilla.good.patterns.challenges.distributionorderservice;

public class ExtraFoodShopDistributor implements Distributor {
    @Override
    public boolean process() {
        System.out.println("ExtraFoodShop is executing this order");
        return true;
    }
}
