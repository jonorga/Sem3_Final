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
        int i = 0;
        while (i < list_size)
        {
            i++;
        }
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}