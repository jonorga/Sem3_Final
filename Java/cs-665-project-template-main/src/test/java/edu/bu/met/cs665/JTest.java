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
		//Object tasks = List.of(
	    //    new ParseCSVTask(), new ParseCSVTask());
	    Task[] tasks = {new ParseCSVTask(), new ParseCSVTask()};

		Object executor = Executors.newFixedThreadPool(3);

		new Worker(tasks[0]);


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
