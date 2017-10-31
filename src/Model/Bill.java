package Model;
import java.sql.Date;


public class Bill {
	
	private String customerID;
    private Integer restaurantCost;
      private Integer seCost;
	private Integer bookingCost;
	private Integer totalCost;
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public Integer getRestaurantCost() {
		return restaurantCost;
	}
	public void setRestaurantCost(Integer restaurantCost) {
		this.restaurantCost = restaurantCost;
	}
	
	public Integer getSeCost() {
		return seCost;
	}
	public void setSeCost(Integer seCost) {
		this.seCost = seCost;
	}
	public Integer getBookingCost() {
		return bookingCost;
	}
	public void setBookingCost(Integer bookingCost) {
		this.bookingCost = bookingCost;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
	

}
