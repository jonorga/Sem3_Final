package test;

import music_recommender.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

// TODO: Build your own version, completely ignore the example implementatiion of pattern

public class JTest {

	@Test
	public void TestBusinessCustomer() {
		System.out.println("Starting program");
		Task[] tasks = {new ParseCSVTask(), new ParseCSVTask()};


		//Worker[] workers = {new Worker(tasks[0]), new Worker(tasks[1])};
		ArrayList<Worker> workers = new ArrayList<>(Arrays.asList( new Worker(tasks[0]), new Worker(tasks[1]) ));


 		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		ExecutorService executor = Executors.newFixedThreadPool(3, ThreadFactory);
		ThreadPoolExecutor mypool = (ThreadPoolExecutor) executor;  
		System.out.println("size of mypool: " + mypool.getPoolSize());
		for (Worker worker : workers) {
			executor.submit(worker);
		}
		//executor.submit(new Worker(tasks[0]));
		//executor.submit( tasks.forEach(task -> new Worker(task)) );
		//executor.invokeAny(workers);
		executor.shutdown();


		//tasks.stream().map(Worker::new).forEach(executor::execute);
    	// All tasks were executed, now shutdown
    	//executor.shutdown();


		System.out.println("Ending program");
		/*
		var tasks = List.of(
	        new PotatoPeelingTask(3),
	        new PotatoPeelingTask(5));
		
		Customer testCase = new Customer();
		testCase.SetCustomerType(new BusinessEmail());
		assertEquals("To whom it may concern, we are reaching out regarding this business email.", 
			testCase.GetEmail());
		*/
	}
}
