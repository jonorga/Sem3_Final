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
		Object tasks = List.of(
	        new ParseCSVTask());
		Object executor = Executors.newFixedThreadPool(3);


		//tasks.stream().map(Worker::new).forEach(executor::execute);
    	// All tasks were executed, now shutdown
    	//executor.shutdown();


    	
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
