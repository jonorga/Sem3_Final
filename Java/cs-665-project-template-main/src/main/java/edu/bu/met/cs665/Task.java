/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: Task.java
 * Description: This file contains the abstract Customer class. 
 */
package music_recommender;

import java.util.concurrent.atomic.*;
import java.io.*;  
import java.util.*;

public abstract class Task {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private String taskName;


    public Task()
    {
        this.id = ID_GENERATOR.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName()
    {
        return taskName;
    }


    public void DoTask()
    {
        ArrayList<String> results = new ArrayList<String>();
        try
        {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "testpy.py", taskName);
            Process process = processBuilder.start();
            Scanner sc = new Scanner(process.getInputStream());

            String result = "";
            while (sc.hasNext())
            {
                results.add(sc.next());
            }
        }
        catch (Exception e)
        {
            System.out.println(taskName + " Task IO exception");
        }
        ProcessResults(results);
    }

    public abstract void ProcessResults(ArrayList<String> results);

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}