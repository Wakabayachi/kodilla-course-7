package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {
    private final TaskFactory factory = new TaskFactory();

    @Test
    void testShoppingTaskCreation() {
        Task task = factory.createTask(TaskType.SHOPPING, "Buy groceries", "Milk", "2.0");
        assertEquals("Buy groceries", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTaskCreation() {
        Task task = factory.createTask(TaskType.PAINTING, "Paint fence", "Brown", "Wooden fence");
        assertEquals("Paint fence", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTaskCreation() {
        Task task = factory.createTask(TaskType.DRIVING, "Drive to work", "Office", "Car");
        assertEquals("Drive to work", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }
}