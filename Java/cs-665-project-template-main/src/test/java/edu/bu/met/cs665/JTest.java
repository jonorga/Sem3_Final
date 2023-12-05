package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;


public class JTest {

	@Test
	public void TestBusinessCustomer() {
		System.out.println("Starting program");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		ExecutorService executor = Executors.newFixedThreadPool(1, ThreadFactory);
		ThreadPoolExecutor mypool = (ThreadPoolExecutor) executor;  
		


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
