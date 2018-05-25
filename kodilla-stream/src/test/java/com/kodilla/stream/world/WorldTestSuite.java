package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");
        Country poland = new Country("Poland", new BigDecimal("40000000"));
        Country germany = new Country("Germany", new BigDecimal("80000000"));
        Country china = new Country("China", new BigDecimal("1379000000"));
        Country japan = new Country("Japan", new BigDecimal("127000000"));
        Country egypt = new Country("Egypt", new BigDecimal("95670000"));
        Country ethiopia = new Country("Ethiopia", new BigDecimal("104000000"));

        europe.addCountry(poland);
        europe.addCountry(germany);
        asia.addCountry(china);
        asia.addCountry(japan);
        africa.addCountry(egypt);
        africa.addCountry(ethiopia);
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal("1825670000"), totalPeopleQuantity);

    }
}
