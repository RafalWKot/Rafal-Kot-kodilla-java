package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Observable {
    private final String firstname;
    private final String surname;
    private final List<String> tasks;
    private final List<Observer> observers;

    public TaskList(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addTask(String taskName) {
        tasks.add(taskName);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
