/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: NameMatchTask.java
 * Description: This file contains the NameMatchTask class. This class extends the Task class. It includes
 * a constructor method which calls the super method. It also overrides the ProcessResults method as 
 * required.
 */
 
package music_recommender;

import java.util.ArrayList;

public class NameMatchTask extends Task {
    /**
     * This is the constructor method which calls super with the necessary variables
     */
    public NameMatchTask(String[] song_input)
    {
        super("NameMatch", song_input);
    }


    /**
     * This is the ProcessResults method which overrides the same method from the parent class. This
     * method reads the first result from the task and prints to the console if it was successful
     */
    @Override
    public String ProcessResults(ArrayList<String> results) {
        if (results.size() == 0)
            return "Fail";
        String result = results.get(0);
        if (result.equals("NameMatchSuccess")) {
            System.out.println("Thread " + getId() + ", name match completed successfully...");
            return "Success";
        }
        else {
            System.out.println("Thread " + getId() + ", name match failed...");
            return "Fail";
        }
    }
}