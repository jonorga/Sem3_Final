package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

// TODO: Make system have inputable songs
// TODO: System shows input and output songs when done
// TODO: Run multiple song recs at the same time


public class JTest {

	@Test
	public void TestBusinessCustomer() {
		System.out.println("Starting program");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		ExecutorService executor = Executors.newFixedThreadPool(1, ThreadFactory);
		ThreadPoolExecutor mypool = (ThreadPoolExecutor) executor;  
		
		// si = ["Crazy Little Thing Called Love", "Queen"]
		String[] song_input = {"Crazy Little Thing Called Love", "Queen"};

		// Name Match Task
		System.out.println("Name Match task started...");
		executor.submit(new Worker(new NameMatchTask()));
		executor.shutdown();
		while (!executor.isTerminated()) {
     		Thread.yield();
    	}



    	// Playlist Agg Task
		System.out.println("Playlist Agg task started...");
		executor = Executors.newFixedThreadPool(1, ThreadFactory);
		executor.submit(new Worker(new PlaylistAggTask()));
		executor.shutdown();
		while (!executor.isTerminated()) {
     		Thread.yield();
    	}


    	// Count Task
		System.out.println("Count task started...");
		executor = Executors.newFixedThreadPool(1, ThreadFactory);
		executor.submit(new Worker(new CountTask()));
		executor.shutdown();
		while (!executor.isTerminated()) {
     		Thread.yield();
    	}


    	// Return Rec Task
		System.out.println("Return Rec task started...");
		executor = Executors.newFixedThreadPool(1, ThreadFactory);
		executor.submit(new Worker(new ReturnRecTask()));
		executor.shutdown();
		while (!executor.isTerminated()) {
     		Thread.yield();
    	}



		/*
		System.out.println("Name Match task started...");
		executor = Executors.newFixedThreadPool(3, ThreadFactory);
		Task[] tasks = {new NameMatchTask(), new NameMatchTask(), new NameMatchTask(), new NameMatchTask()};
		ArrayList<Worker> workers = new ArrayList<>(Arrays.asList( 
			new Worker(tasks[0]), new Worker(tasks[1]), new Worker(tasks[2]), new Worker(tasks[3])
			));
		for (Worker worker : workers) {
			executor.submit(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
     		Thread.yield();
    	}
		*/


		System.out.println("Ending program");
	}
}
