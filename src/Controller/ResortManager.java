package Controller;

import Model.Bill;
import Model.BillDB;
import Model.Customer;
import Model.CustomerDB;

public class ResortManager extends Manager
{
	
	
	
	public ResortManager(String id,String name,String designation)
	{
	    
		this.name = name;
		this.id = id;
		this.designation = designation;
		
	
   }
	
   public ResortManager()
    {
	  
	}
	
	
	
	public void viewBill(String cusomerID)
	{
		
		
		
	}
	

    public void generateFinalBill(String customerID)
	{
    	Customer customer = CustomerDB.getCustomerDetails(customerID);
		Bill bill = BillDB.getBillDetails(customerID);
		
		
	}
	
 
	
	
}
