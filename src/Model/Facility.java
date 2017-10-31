package Model;

public class Facility {
	
	protected String customerID;
	protected String itemCode;
	protected String itemName;
	protected Integer itemCost;
	
    
    
    
    public Facility()
	{
		
	}
    
    
	protected Facility(String itemCode, String itemName, Integer itemCost) {
	
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemCost = itemCost;
		
	}
     
	
	
	public void setItemCode(String code)
	{
		this.itemCode = code;
	}
	
	public void setItemName(String name)
	{
		this.itemName = name;
	}
	public void setItemCost(Integer itemCost)
	{
		
		this.itemCost = itemCost;
	}
	
	
	public String getItemCode() {
		return itemCode;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	
	public Integer getItemCost() {
		return itemCost;
	}
	
	
  

}
