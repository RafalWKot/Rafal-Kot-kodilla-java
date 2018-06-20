package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.medium.TwitterPublisher;

public class ZGeneration extends User {

    public ZGeneration(String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
