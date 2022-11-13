package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testFindByListName() {
        //Given
        String name = "TaskListName";
        TaskList taskList = new TaskList(name, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        List<TaskList> readTaskList = taskListDao.findByListName(name);
        assertEquals(readTaskList.get(0).getListName(), name);

        //CleanUp
        taskListDao.deleteById(taskList.getId());
    }
}
