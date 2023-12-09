package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import java.util.*;
import java.util.concurrent.*;

public class JTest {
	@Test
	public void TestMultipleInputs() {
		System.out.println("Starting multiple input test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		
		String[] song_input1 = {"Crazy Little Thing Called Love", "Queen"};
		String[] song_input2 = {"Harder, Better, Faster, Stronger", "Daft Punk"};
		String[] song_input3 = {"Yonkers", "Tyler, The Creator"};
		String[][] input_songs = {song_input1, song_input2, song_input3};

		
		String[] taskTypes = {"NameMatch", "PlaylistAgg", "Count", "ReturnRec"};
		ExecutorService executor;
		Worker worker = null;
		for (String taskType : taskTypes) {
			executor = Executors.newFixedThreadPool(3, ThreadFactory);
			for (String[] si : input_songs) {
				if (taskType.equals("NameMatch"))
					executor.submit(new Worker(new NameMatchTask(si)));
				else if (taskType.equals("PlaylistAgg"))
					executor.submit(new Worker(new PlaylistAggTask(si)));
				else if (taskType.equals("Count"))
					executor.submit(new Worker(new CountTask(si)));
				else if (taskType.equals("ReturnRec")) {
					worker = new Worker(new ReturnRecTask(si));
					executor.submit(worker);
				}
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
	     		Thread.yield();
	    	}
	    }
	    assertEquals("Success", worker.getResult());
		System.out.println("Completing multiple input test\n\n");
	}

	
	@Test
	public void TestSingleInput() {
		System.out.println("Starting single input test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		
		String[] song_input = {"Crazy Little Thing Called Love", "Queen"};
		String[] taskTypes = {"NameMatch", "PlaylistAgg", "Count", "ReturnRec"};
		ExecutorService executor;
		Worker worker = null;
		for (String taskType : taskTypes) {
			executor = Executors.newFixedThreadPool(1, ThreadFactory);
			if (taskType.equals("NameMatch"))
				executor.submit(new Worker(new NameMatchTask(song_input)));
			else if (taskType.equals("PlaylistAgg"))
				executor.submit(new Worker(new PlaylistAggTask(song_input)));
			else if (taskType.equals("Count"))
				executor.submit(new Worker(new CountTask(song_input)));
			else if (taskType.equals("ReturnRec")) {
				worker = new Worker(new ReturnRecTask(song_input));
				executor.submit(worker);
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
	     		Thread.yield();
	    	}
	    }
	    assertEquals("Success", worker.getResult());
		System.out.println("Completing single input test\n\n");
	}
	
	
	@Test
	public void TestSongNotInList() {
		System.out.println("Starting song not in list test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		
		String[] song_input = {"foo", "bar"};
		ExecutorService executor = Executors.newFixedThreadPool(1, ThreadFactory);
	
		Worker worker = new Worker(new NameMatchTask(song_input));
		executor.submit(worker);
		executor.shutdown();
		while (!executor.isTerminated()) {
	   		Thread.yield();
	    }
		assertEquals("Fail", worker.getResult());

		System.out.println("Completing invalid input test\n\n");
	}

	
	@Test
	public void TestInvalidInput() {
		System.out.println("Starting song not in list test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();

 		String[] song_input = {"foo"};
 		ExecutorService executor = Executors.newFixedThreadPool(1, ThreadFactory);
	
		Worker worker = new Worker(new NameMatchTask(song_input));
		executor.submit(worker);
		executor.shutdown();
		while (!executor.isTerminated()) {
	   		Thread.yield();
	    }
	    assertEquals("Fail", worker.getResult());
		System.out.println("Completing invalid input test\n\n");
	}
}
