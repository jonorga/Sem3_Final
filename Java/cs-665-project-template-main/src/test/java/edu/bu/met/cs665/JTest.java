package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.*;

// TODO: Build out other tests

public class JTest {

	@Test
	public void TestBusinessCustomer() {
		System.out.println("Starting program");
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

		System.out.println("Ending program");
	}
}
