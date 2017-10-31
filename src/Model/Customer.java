package Model;

public class Customer {

	private String firstName;
	private String lastName;
	private String middleName;
	private String state,city;
	private String id;
	private String address;
	private Integer contactNumber;
	String checkIn,checkOut;

	
	public Customer()
	{
	
		
	}
	public Customer(String firstName, String middleName,String lastName, String id,
			String address, Integer contactNumber) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.contactNumber = contactNumber;
		
	}


	public void hasCheckedOut(String customerID,boolean hasCheckedOut)
	{
		
		
	}
	
	
	
	public void setState(String sate)
	{
		
		this.state = state;
		
	}
	
	public String getState()
	{
		
		return this.state;
		
	}
	
	public void setCity(String city)
	{
		
		this.city = city;
		
	}
	
	public void setCheckIn(String checkIn)
	{
		this.checkIn = checkIn;
	}

	public String getCheckIn()
	{
		return this.checkIn;
	}
	
	public void setCheckOut(String checkOut)
	{
		this.checkOut = checkOut;
	}

	public String getCheckOut()
	{
		return this.checkOut;
	}
	
	public String getCity()
	{
		
		return this.city;
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName()
	{
		return this.middleName;
	}


	public void setId(String id) {
		this.id = id;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	


	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Integer getContactNumber() {
		return this.contactNumber;
	}

	
	
	
	
}
