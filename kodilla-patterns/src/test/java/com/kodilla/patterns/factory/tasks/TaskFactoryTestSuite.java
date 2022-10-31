package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING_TASK);
        drivingTask.executeTask();
        //Then
        assertTrue(drivingTask.isTaskExecuted());
        assertEquals("Driving task", drivingTask.getTaskName());
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        //Then
        assertTrue(shoppingTask.isTaskExecuted());
        assertEquals("Shopping task", shoppingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.createTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();
        //Then
        assertTrue(paintingTask.isTaskExecuted());
        assertEquals("Painting task", paintingTask.getTaskName());
    }
}
