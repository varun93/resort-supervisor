package Controller;

import Model.BillDB;
import Model.SportsEntertainmentFacility;

public class SEManager extends FacilityManager{


	public SEManager()
	{
		super();
		facility = new SportsEntertainmentFacility();
	}
	public SEManager(String id,String name,String designation) {
		super(id,name,designation);

	}



	public void viewMenu() {

		//view all the sports and  entertainment related stuff

	}



	public void viewBill(String customerID) {


	}


	public void calculateFacilityBill(Integer cost, String customerID) {

		BillDB.updateSECost(cost, customerID);	

	}




}



