/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: NameMatchTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

import java.io.*;  
import java.util.*;

public class NameMatchTask extends Task {
    @Override
    public void DoTask()
    {
        System.out.println("NameMatchTask DoTask method, ID: " + getId());
        try
        {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "testpy.py", "NameMatch");
            Process process = processBuilder.start();
            Scanner sc = new Scanner(process.getInputStream());

            String result = "";
            while (sc.hasNext())
            {
                result = sc.next();
                System.out.println(result);
            }
            if (result.equals("success")) System.out.println("Name Match Task complete");
        }
        catch (Exception e)
        {
            System.out.println("Name Match Task IO exception");
        }
    }
   

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}