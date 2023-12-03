/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: CountTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

public class Worker implements Runnable {
    private final Task task;

    public Worker(final Task task) {
        this.task = task;
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
    @Override
    public void run() {
        task.DoTask();
    }
}