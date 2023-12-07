/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: ReturnRecTask.java
 * Description: This file contains the ReturnRecTask class. This class extends the Task class. It includes
 * a constructor method which calls the super method. It also overrides the ProcessResults method as 
 * required.
 */
 
package music_recommender;

import java.util.ArrayList;

public class ReturnRecTask extends Task {
    /**
     * This is the constructor method which calls super with the necessary variables
     */
    public ReturnRecTask(String[] song_input)
    {
        super("ReturnRec", song_input);
    }


    /**
     * This is the ProcessResults method which overrides the same method from the parent class. This
     * method takes the results from the task and parses out the recommended song name and artist
     * then prints those values and the input song to the console
     */
    @Override
    public String ProcessResults(ArrayList<String> results) {
        int list_size = results.size();
        int i = 0, song_int = 0, artist_int = 0;
        String result = "", song_name = "", artist_name = "";
        while (i < list_size)
        {
            result = results.get(i);
            if (result.equals("Song:")) {
                song_int = i;
            }
            else if (result.equals("Artist:")) {
                int j = song_int + 1;
                artist_int = i;
                while (j < artist_int)
                {
                    song_name += results.get(j) + " ";
                    j++;
                }
                i++;
                while (i < list_size - 1)
                {
                    artist_name += results.get(i) + " ";
                    i++;
                }
            }
            i++;
        }
        String[] song_input = getSongInput();
        System.out.println("Input song:" );
        System.out.println("Song name: " + song_input[0]);
        System.out.println("Artist name: " + song_input[1]);
        System.out.println("Song recommendation:");
        System.out.println("Song name: " + song_name);
        System.out.println("Artist name: " + artist_name);

        return "Success";
    }
}