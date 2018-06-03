package com.kodilla.good.patterns.challenges.productorderservice;

public class CommonInformationService implements InformationService {

    @Override
    public void information(User user) {
        System.out.println("Sending the email to " + user.getName() + " " + user.getSurname());
    }
}
