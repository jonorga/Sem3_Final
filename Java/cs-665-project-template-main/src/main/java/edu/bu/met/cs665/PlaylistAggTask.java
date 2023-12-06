/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: PlaylistAggTask.java
 * Description: This file contains the PlaylistAggTask class. This class extends the Task class. It includes
 * a constructor method which calls the super method. It also overrides the ProcessResults method as 
 * required.
 */
 
package music_recommender;

import java.util.ArrayList;

public class PlaylistAggTask extends Task {
    /**
     * This is the constructor method which calls super with the necessary variables
     */
    public PlaylistAggTask(String[] song_input)
    {
        super("PlaylistAgg", song_input);
    }


    /**
     * This is the ProcessResults method which overrides the same method from the parent class. This
     * method reads the first result from the task and prints to the console if it was successful
     */
    @Override
    public String ProcessResults(ArrayList<String> results) {
        String result = results.get(0);
        if (result.equals("PlaylistAggSuccess"))
            System.out.println("Thread " + getId() + ", playlist Agg completed successfully...");
        return "";
    }
}