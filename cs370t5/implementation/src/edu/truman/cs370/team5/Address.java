package edu.truman.cs370.team5;

public class Address 
{
	private String street;
	private String city;
	private String state;
	private String zip5;
	private String zip4;
	private boolean normalizableFlag = true;
	
	public Address(String street, String city, String state, String zip5, String zip4)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip5 = zip5;
		this.zip4 = zip4;
	}
	
	public Address(String[] addressArray)
	{
		this.street = addressArray[0];
		this.city = addressArray[1];
		this.state = addressArray[2];
		this.zip5 = addressArray[3];
		this.zip4 = addressArray[4];
	}
	
	public String getStreetAddress()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getZipFive()
	{
		return zip5;
	}
	
	public String getZipFour()
	{
		return zip4;
	}
	
	public boolean getNormalizableFlag()
	{
		return normalizableFlag;
	}
	
	public void setNormalizableFlag(boolean flag)
	{
		normalizableFlag = flag;
	}

	public boolean equals(Address altAddress)
	{
		boolean equals = true;
		 if(!(street.equals(altAddress.getStreetAddress())))
		 {
			equals = false;
		 }
		 if(!(city.equals(altAddress.getCity())))
		 {
			equals = false;
		 }
		 if(!(state.equals(altAddress.getState())))
		 {
			equals = false;
		 }
		 if(!(zip5.equals(altAddress.getZipFive())))
		 {
			equals = false;
		 }
		 if(!(zip4.equals(altAddress.getZipFour())))
		 {
			equals = false;
		 }
		 return equals;
	}
}
