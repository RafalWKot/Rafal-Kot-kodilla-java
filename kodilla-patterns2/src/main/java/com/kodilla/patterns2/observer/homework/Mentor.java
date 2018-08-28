package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String firstname;
    private final String secondname;
    private int countTask;

    public Mentor(String firstname, String secondname) {
        this.firstname = firstname;
        this.secondname = secondname;
    }

    @Override
    public void update(TaskList taskList) {
        System.out.println("Student " + taskList.getFirstname() + " " + taskList.getSurname() + " added task.");
        countTask++;
    }

    public int getCountTask() {
        return countTask;
    }
}
