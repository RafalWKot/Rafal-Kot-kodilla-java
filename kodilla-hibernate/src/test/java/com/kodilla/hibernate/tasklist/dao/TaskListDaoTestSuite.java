package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {

        //Given
        TaskList taskList = new TaskList("toDO", "Project 1");

        //When
        taskListDao.save(taskList);

        //Then
        List<TaskList> readTaskList = taskListDao.findByListName(taskList.getListName());
        Assert.assertEquals(1, readTaskList.size());
        Assert.assertEquals(taskList.getDescription(), readTaskList.get(0).getDescription());

        //CleanUp
        taskListDao.delete(taskList);
    }
}
