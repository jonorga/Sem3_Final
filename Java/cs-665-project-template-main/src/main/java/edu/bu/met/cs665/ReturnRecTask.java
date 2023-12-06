/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: ReturnRecTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

import java.util.ArrayList;

public class ReturnRecTask extends Task {
   public ReturnRecTask()
    {
        super();
        setTaskName("ReturnRec");
    }

    @Override
    public void ProcessResults(ArrayList<String> results) {
        int list_size = results.size();
        int i = 0, song_int = 0, artist_int = 0;
        String result = "", song_name = "", artist_name = "";
        while (i < list_size)
        {
            result = results.get(i);
            System.out.println(result);
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
        System.out.println("Song recommendation:");
        System.out.println("Song: " + song_name);
        System.out.println("Artist: " + artist_name);
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}