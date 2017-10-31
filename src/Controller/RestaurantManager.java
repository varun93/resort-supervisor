package Controller;

import javax.swing.table.TableModel;

import Model.BillDB;
import Model.RestaurantFacility;
import View.Restaurant;

public class RestaurantManager extends FacilityManager {
	
	
   public RestaurantManager()
   {
		 super();
		 facility = new RestaurantFacility();
   }
	
    
     
   
	public RestaurantManager(String id,String name,String designation) {
		 super(id,name,designation);
		
	}
	
	
	  
 public void viewMenu() {
		
	   //view all the sports and  entertainment related stuff 
		
	}

  

   public void calculateFacilityBill(Integer cost, String customerID) {

	
	BillDB.updateRestarantCost(cost, customerID);
	 
	
}



public void viewBill(String customerID) {
	
	
}

}
