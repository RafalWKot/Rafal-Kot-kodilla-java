package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.medium.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User tom = new Millenials("Tom");
        User ann = new YGeneration("Ann");
        User peter = new ZGeneration("Peter");

        //When
        String tomSocial = tom.getMedium();
        System.out.println("Tom use " + tomSocial);
        String annSocial = ann.getMedium();
        System.out.println("Ann use " + annSocial);
        String peterSocial = peter.getMedium();
        System.out.println("Peter use " + peterSocial);

        //Then
        Assert.assertEquals("Facebook", tomSocial);
        Assert.assertEquals("Snapchat", annSocial);
        Assert.assertEquals("Twitter", peterSocial);
    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User tom = new Millenials("Tom");

        //When
        String tomSocial = tom.getMedium();
        System.out.println("Tom used " + tomSocial);
        tom.setSocialPublisher(new SnapchatPublisher());
        tomSocial = tom.getMedium();
        System.out.println("Tom has changed to use " + tomSocial);

        //Then
        Assert.assertEquals("Snapchat", tomSocial);
    }
}
