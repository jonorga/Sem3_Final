/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: CountTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

import java.util.ArrayList;

public class CountTask extends Task {
    public CountTask(String[] song_input)
    {
        super("Count", song_input);
    }

    @Override
    public void ProcessResults(ArrayList<String> results) {
        String result = results.get(0);
        if (result.equals("CountSuccess"))
            System.out.println("Count completed successfully...");
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}