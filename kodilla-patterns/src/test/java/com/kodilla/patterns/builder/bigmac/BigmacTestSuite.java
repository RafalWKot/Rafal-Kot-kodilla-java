package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                            .bun("bun")
                            .burgers(2)
                            .sauce("spicy")
                            .ingredients("onion")
                            .ingredients("tomato")
                            .ingredients("garlic")
                            .ingredients("lettuce")
                            .build();
        System.out.println(bigmac);
        //When

        //Then
        Assert.assertEquals("bun", bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
        Assert.assertEquals(4, bigmac.getIngredients().size());
    }
}
