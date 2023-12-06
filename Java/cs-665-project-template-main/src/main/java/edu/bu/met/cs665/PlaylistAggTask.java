/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: PlaylistAggTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

import java.util.ArrayList;

public class PlaylistAggTask extends Task {
    public PlaylistAggTask(String[] song_input)
    {
        super("PlaylistAgg", song_input);
    }

    @Override
    public void ProcessResults(ArrayList<String> results) {
        String result = results.get(0);
        if (result.equals("PlaylistAggSuccess"))
            System.out.println("Playlist Agg completed successfully...");
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}