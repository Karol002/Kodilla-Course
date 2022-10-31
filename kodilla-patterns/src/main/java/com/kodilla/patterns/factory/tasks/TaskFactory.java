package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task createTask(String taskClass) {
        return switch (taskClass) {
            case SHOPPING_TASK -> new ShoppingTask("Shopping task", "bike", 1);
            case PAINTING_TASK -> new PaintingTask("Painting task", "blue", "sky");
            case DRIVING_TASK -> new DrivingTask("Driving task", "Canada", "car");
            default -> null;
        };
    }
}
