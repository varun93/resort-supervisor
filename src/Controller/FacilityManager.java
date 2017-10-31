package Controller;

import Model.Bill;
import Model.Facility;

public abstract class FacilityManager extends Manager {
	
	
     protected Bill bill;
	 protected Facility facility;
	
    public FacilityManager(String id,String name,String designation)
	{
    	this.name = name;
		this.id = id;
		this.designation = designation;
	    bill = new Bill();
	}
	
	
	
    public FacilityManager() {
    	
    	
		// TODO Auto-generated constructor stub
	}


    
	
    public void calculateFacilityBill(String customerID)
	{
		
    	
    	
	}

    
	public void calculateFacilityBill(Integer cost,String customerID)
	{
		
	}
	
	public abstract void viewBill(String customerID);
	
	public abstract void viewMenu();

}
