/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: Task.java
 * Description: This file contains the abstract Task class. It contains an Atomic Integer to give each thread
 * a unique name, as well as the task's name and the input song. The methods in this class include the 
 * constructor method which sets all the values and getter methods which return the private variables. Lastly
 * it contains the DoTask method and the abstract ProcessResults method
 */
package music_recommender;

import java.util.concurrent.atomic.*;
import java.io.*;  
import java.util.*;

public abstract class Task {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private final String[] song_input;
    private final String taskName;


    /**
     * This is the constructor method which sets the instance variables
     */
    public Task(String taskName, String[] song_input)
    {
        this.id = ID_GENERATOR.incrementAndGet();
        this.taskName = taskName;
        this.song_input = song_input;
    }


    /**
     * This is the id getter method that returns the instance id
     * @return int
     */
    public int getId() {
        return id;
    }


    /**
     * This is the taskName getter method that returns the instance taskName
     * @return String
     */
    public String getTaskName()
    {
        return taskName;
    }


    /**
     * This is the song_input getter method that returns the instance song_input
     * @return String[]
     */
    public String[] getSongInput()
    {
        return song_input;
    }


    /**
     * This is the DoTask method that is actually called in the run method of the worker. It calls the
     * python script with the input song info and the relevant task name. After that it gathers the 
     * returned results and passes them to the ProcessResults method and return the results
     * @return String
     */
    public String DoTask()
    {
        ArrayList<String> results = new ArrayList<String>();
        try
        {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "pyTasks.py", taskName, 
                "Song", song_input[0], "Artist", song_input[1]);
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
            return "Fail";
        }
        return ProcessResults(results);
    }


    /**
     * This is the abstract ProcessResults method, this was declared to force the sub-classes to
     * implement their own method to handle the results of their task
     * @return String
     */
    public abstract String ProcessResults(ArrayList<String> results);
}