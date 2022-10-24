package com.kodilla.spring.portfolio;

public class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void checkTaskQuantity() {
        System.out.println("Number of to do tasks " + toDoList.getTasks().size());
        System.out.println("Number of inn progress tasks " + inProgressList.getTasks().size());
        System.out.println("Number of done tasks " + doneList.getTasks().size());
    }

    public void addToDoTask() {
        toDoList.addTask("To do");
    }

    public void addInProgressTask() {
        inProgressList.addTask("In progress");
    }

    public void addDoneTask() {
        doneList.addTask("Done");
    }

    @Override
    public String toString() {
        return "Tasks lists\n" +
                "To Do List: " + toDoList.getTasks() + " size: " + toDoList.getTasks().size() + "\n" +
                "In Progress List: " + inProgressList.getTasks() + " size: " + inProgressList.getTasks().size() + "\n" +
                "Done List: " + doneList.getTasks() + " size: " + doneList.getTasks().size();
    }
}
