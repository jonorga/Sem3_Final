package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import java.util.*;
import java.util.concurrent.*;

// TODO: Build out invalid input test
// TODO: update documentation for Worker, Task and all subclasses

public class JTest {
	@Ignore
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
		for (String taskType : taskTypes) {
			executor = Executors.newFixedThreadPool(3, ThreadFactory);
			for (String[] si : input_songs) {
				if (taskType.equals("NameMatch"))
					executor.submit(new Worker(new NameMatchTask(si)));
				else if (taskType.equals("PlaylistAgg"))
					executor.submit(new Worker(new PlaylistAggTask(si)));
				else if (taskType.equals("Count"))
					executor.submit(new Worker(new CountTask(si)));
				else if (taskType.equals("ReturnRec"))
					executor.submit(new Worker(new ReturnRecTask(si)));
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
	     		Thread.yield();
	    	}
	    }

		System.out.println("Ending multiple input test\n\n");
	}

	@Ignore
	@Test
	public void TestSingleInput() {
		System.out.println("Starting single input test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		
		String[] song_input = {"Crazy Little Thing Called Love", "Queen"};
		String[] taskTypes = {"NameMatch", "PlaylistAgg", "Count", "ReturnRec"};
		ExecutorService executor;
		for (String taskType : taskTypes) {
			executor = Executors.newFixedThreadPool(1, ThreadFactory);
			if (taskType.equals("NameMatch"))
				executor.submit(new Worker(new NameMatchTask(song_input)));
			else if (taskType.equals("PlaylistAgg"))
				executor.submit(new Worker(new PlaylistAggTask(song_input)));
			else if (taskType.equals("Count"))
				executor.submit(new Worker(new CountTask(song_input)));
			else if (taskType.equals("ReturnRec"))
				executor.submit(new Worker(new ReturnRecTask(song_input)));
			executor.shutdown();
			while (!executor.isTerminated()) {
	     		Thread.yield();
	    	}
	    }

		System.out.println("Ending single input test\n\n");
	}

	@Ignore
	@Test
	public void TestSongNotInList() {
		System.out.println("Starting invalid input test");
 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		
		String[] song_input = {"foo", "bar"};
		String[] taskTypes = {"NameMatch", "PlaylistAgg", "Count", "ReturnRec"};
		Worker worker = null;
		ExecutorService executor;
		executor = Executors.newFixedThreadPool(1, ThreadFactory);
	
		worker = new Worker(new NameMatchTask(song_input));
		executor.submit(worker);
		executor.shutdown();
		while (!executor.isTerminated()) {
	   		Thread.yield();
	    }
		assertEquals("Fail", worker.getResult());

		System.out.println("Ending invalid input test\n\n");
	}

	@Test
	public void TestInvalidInput() {

	}
}
