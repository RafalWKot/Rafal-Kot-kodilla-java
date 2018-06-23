package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask( String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("Driving", "home" , "car" );
            case PAINTING:
                return new PaintingTask("Painting", "Blue", "Room");
            case SHOPPING:
                return new ShoppingTask("Shopping", "Computer", 1.0);
            default:
                return null;
        }
    }
}
