/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: ParseCSVTask.java
 * Description: This file contains the abstract Customer class. 
 */
 
package music_recommender;

import java.io.*;  
import java.util.*;

public class ParseCSVTask extends Task {
   
   @Override
   public void DoTask()
   {
        System.out.println("ParseCSVTask DoTask method, ID: " + getId());
        try
        {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "testpy.py", "another");
            Process process = processBuilder.start();
            Scanner sc = new Scanner(process.getInputStream());
            
            while (sc.hasNext())
            {
                System.out.println(sc.next());
            }

            /*
            Scanner sc = new Scanner(new File("spotify_dataset.csv"));
            sc.useDelimiter(",");
            int count = 0;
            while (sc.hasNext())
            {
                count++;
                if (count % 1000 == 0)
                    break;
            }
            sc.close();  //closes the scanner
            System.out.println("Read " + count + " lines");
            */
        }
        catch (Exception e)
        {
            System.out.println("Parse CSV Task IO exception");
        }
   }


    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}