package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Board {


    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    @Autowired
    public Board(@Qualifier("toDoList") TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoList(String taskName) {
        toDoList.addTask(taskName);
    }

    public void addInProgressList(String taskName) {
        inProgressList.addTask(taskName);
    }

    public void addDoneList(String taskName) {
        doneList.addTask(taskName);
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
