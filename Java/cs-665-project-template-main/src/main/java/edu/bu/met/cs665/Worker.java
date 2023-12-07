/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: Worker.java
 * Description: This file contains the Worker class which implements the Runnable interface. This class has
 * two instance variables, a Task and a String result to store the result of the task. It also has a
 * constructor method, a getResult method, and the required run method.
 */
 
package music_recommender;

public class Worker implements Runnable {
    private final Task task;
    private String result;

    /**
     * This is the constructor method which sets the Task variable
     */
    public Worker(final Task task) {
        this.task = task;
    }

    /**
     * This is the getter method for the result instance variable
     * @return String
     */
    public String getResult() {
        return result;
    }

    /**
     * This method is the method required by the runnable interface, it calls the task to perform its
     * function
     */
    @Override
    public void run() {
        result = task.DoTask();
    }
}