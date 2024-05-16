package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public Task createTask(TaskType taskType, String taskName, String... args) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask(taskName, args[0], Double.parseDouble(args[1]));
            case PAINTING:
                return new PaintingTask(taskName, args[0], args[1]);
            case DRIVING:
                return new DrivingTask(taskName, args[0], args[1]);
            default:
                throw new IllegalArgumentException("Unknown task type");
        }
    }
}