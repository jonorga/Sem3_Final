/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/23/2023
 * File Name: Task.java
 * Description: This file contains the abstract Customer class. 
 */
package music_recommender;

import java.util.concurrent.atomic.*;

public abstract class Task {
   private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
   private final int id;


   public Task()
   {
        this.id = ID_GENERATOR.incrementAndGet();
   }

   public void DoTask() {}

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
}