package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;

import Controller.BookingManager;

public class BookingManagerTesting {

	BookingManager manager;
	
	@Before
	public void setup() throws Exception
	{
		manager = new BookingManager();
	}
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void testAvailability() throws Exception
	{
		boolean available = manager.checkAvailability(2,"SINGLE BED AC");
		assertTrue("Testing for room availability",available == true);
	}
	
	@Test
	public void calculateBill() throws Exception
	{
		
		
	}
	
	
}
