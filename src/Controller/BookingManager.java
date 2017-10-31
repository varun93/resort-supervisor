package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;

import Model.BillDB;
import Model.BookingFacility;
import Model.Customer;
import Model.CustomerDB;
import Model.MenuDB;
import View.Booking;


public class BookingManager extends FacilityManager{

	


	public void viewMenu() {

		//view all the sports and  entertainment related stuff
		//create an appropriate view from facility

	}

   
	public BookingManager()
	{
		super();
		facility = new BookingFacility();
	}
	
	public BookingManager(String id,String name,String designation) {
		super(id,name,designation);

	}

	
	public boolean checkAvailability(int number,String type)
	{
		
		return MenuDB.areRoomsAvailable(type, number);
		
	}
	
	
	
	public void calculateFacilityBill(String customerID)
	{
		int cost = MenuDB.getBookingCost(customerID);
 	   
	    int diff = difference(CustomerDB.getCheckin(customerID), CustomerDB.getCheckout(customerID));
	  
	   
	//	BillDB.updateBookingCost(diff*cost, customerID);
		
	}

  public void calculateFacilityBill(Integer cost, String customerID)
    {

		

	}

	public void allotRoom(String customerId,String roomType,int number)
	{
		
		MenuDB.allotRoom(customerId,number,roomType);		
		
	}


	public void viewBill(String customerID) 
	{

		
		
	}

	public void checkOutCustomer(String customerID)
	{

		CustomerDB.checkoutCustomer(customerID);
		
	}
	
	

	private boolean isLeapYear(int year)
    {
    	if(year%4==0)
    	{
    		if(year%100==0 && year%400!=0)
    		{
    		return false;	
    		}
    		else if(year%400==0)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
                                            
    
    private int difference(String checkin,String checkout)
    {
    	 
    	int diff=0;
    	if(Integer.parseInt(checkout.substring(4, 6)) == Integer.parseInt(checkin.substring(4, 6)) )
    	diff = Integer.parseInt(checkout.substring(6)) -  Integer.parseInt(checkin.substring(6));
    	else
    	{
    		switch(Integer.parseInt(checkout.substring(4, 6)))
    		{
    		case 1 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 2:if(isLeapYear(Integer.parseInt(checkout.substring(0,4))))
    		{
    			diff = Integer.parseInt(checkout.substring(6)) + (29- Integer.parseInt(checkin.substring(6)));
    		}
    		else
    		{
    			diff = Integer.parseInt(checkout.substring(6)) + (28- Integer.parseInt(checkin.substring(6)));	
    		}
    		break;
    		case 3 :diff = Integer.parseInt(checkout.substring(6)) + (31 - Integer.parseInt(checkin.substring(6)));
    		break;
    		case 4:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 5 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 6:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 7 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 8:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 9 :diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 10:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 11:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 12:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		
    			
    		
    		}
    		
    	}
    	return diff;
    }
          
	
	
	public Customer getCustomerDetails(String customerID)
	{

		return CustomerDB.getCustomerDetails(customerID);

	}


	public void addCustomer(String id,String firstName,String middleName,String lastName,String state,String city,String address,Integer contactNumber)
	{
		
		
		Customer customer = new Customer();
	    customer.setFirstName(firstName);
	    customer.setMiddleName(middleName);
	    customer.setLastName(lastName);
	    customer.setContactNumber(contactNumber);
 	    customer.setAddress(address);
	    customer.setState(state);//send you might miss this
	    customer.setCity(city);
	    customer.setId(id);
	    customer.setCheckIn(new SimpleDateFormat("yyyyddMM").format(new Date()));//logic
	    
	    CustomerDB.insertCustomerDetails(customer);
		

	}

	/*
	 
public static void main(String args[])
{
	
	BookingManager bm = new BookingManager();
	bm.start();

	
}

*/
private void start() {
	JFrame frame = new JFrame("bill");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,400);
	frame.add(new Booking());
}
	

}
