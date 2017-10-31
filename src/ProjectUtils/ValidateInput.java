package ProjectUtils;

public class ValidateInput {
	
	public static boolean validateFirstName(String firstName)
	{
		return firstName.matches("[A-z]{2,20}");
	}
	
	public static boolean validateMiddleName(String middleName)
	{
		return middleName.matches("[A-z]{0,20}");
	}
	
	public static boolean validateLastName(String lastName)
	{
		return lastName.matches("[A-z]{0,20}");
	}
	
	public static boolean validateCity(String city)
	{
		return city.matches("[A-z]{2,20}");
	}
	
	public static boolean validateAddress(String address)
	{
		return address.matches("\\d+\\s+([A-z]+|[A-z]+\\s[A-z]+)");
	}
	
	public static boolean validatephoneNumber(String phoneNumber)
	{
		return phoneNumber.matches("\\d{9-10}");
	}

}
