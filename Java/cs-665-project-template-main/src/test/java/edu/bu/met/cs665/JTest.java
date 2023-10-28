package test;

import email_generator.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JTest {

	@Test
	public void TestBusinessCustomer() {
		Customer testCase = new Customer();
		testCase.SetCustomerType(new BusinessEmail());
		assertEquals("To whom it may concern, we are reaching out regarding this business email.", 
			testCase.GetEmail());
	}

	@Test
	public void TestReturningCustomer() {
		Customer testCase = new Customer();
		testCase.SetCustomerType(new ReturningEmail());
		assertEquals("Welcome back, we are reaching out regarding to your renewal of our services.", 
			testCase.GetEmail());
	}

	@Test
	public void TestFrequentCustomer() {
		Customer testCase = new Customer();
		testCase.SetCustomerType(new FrequentEmail());
		assertEquals("Hello again! we are reaching out regarding our continuing business together.", 
			testCase.GetEmail());
	}

	@Test
	public void TestNewCustomer() {
		Customer testCase = new Customer();
		testCase.SetCustomerType(new NewEmail());
		assertEquals("Welcome! we are reaching out regarding our new business partnership.", 
			testCase.GetEmail());
	}

	@Test
	public void TestVIPCustomer() {
		Customer testCase = new Customer();
		testCase.SetCustomerType(new VIPEmail());
		assertEquals("To our most valued customer, we are reaching out to let you know we value your business.", 
			testCase.GetEmail());
	}
}
