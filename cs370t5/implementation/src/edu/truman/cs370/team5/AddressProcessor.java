package edu.truman.cs370.team5;

import java.util.ArrayList;

/**
 * Transforms a list of String arrays into a list of Address objects and
 * passes it to a Normalizer. The AddressProcessor then converts the list
 * of normalized Address to a list of String arrays.
 * 
 * @author John
 *
 */
public class AddressProcessor {
	
	private ArrayList<String[]> addresses;
	private ArrayList<String[]> newAddresses;
	private ArrayList<Address> addressList;
	
	/**
	 * AddressProcessor constructor.
	 * @param inputAddresses
	 */
	public AddressProcessor(ArrayList<String[]> inputAddresses){
		addresses = inputAddresses;
		
		addressList = new ArrayList<Address>();
	}

	/**
	 * Returns the input ArrayList of String arrays
	 * @return addresses, a list of addresses stored as String arrays
	 */
	public ArrayList<String[]> getAddresses()
	{
		return addresses;
	}
	
	/**
	 * Returns the ArrayList of normalized addresses
	 * @return newAddresses
	 */
	public ArrayList<String[]> getNewAddresses() 
	{
		return newAddresses;
	}
	
	/**
	 * Converts the input list of addresses to a list of normalized addresses
	 */
	public void process() 
	{
		String street;
		String city;
		String state;
		String zip5;
		String zip4;
		String[] address = new String[5];
		for (int i = 0; i < addresses.size(); i++) 
		{
			address = addresses.get(i);
			street = address[0];
			city = address[1];
			state = address[2];
			zip5 = address[3];
			zip4 = address[4];
			
			addressList.add(new Address(street,city,state,zip5,zip4));
		}

		Normalizer normalizer = new Normalizer(addressList);
		addressList = normalizer.normalizeAddressList();
		
		changeAddressesToString();
	}
	
	/**
	 * Converts a list of Address objects to a list of String arrays representing addresses
	 */
	public void changeAddressesToString()
	{
		newAddresses = new ArrayList<String[]>();
		
		Address address;
		
		
		for (int i = 0; i<addressList.size(); i++){
			String[] addressArray = new String[6];
			
			address = addressList.get(i);
			
			addressArray[0] = address.getStreetAddress();
			addressArray[1] = address.getCity();
			addressArray[2] = address.getState();
			addressArray[3] = address.getZipFive();
			addressArray[4] = address.getZipFour();
			if (address.getNormalizableFlag() == true) {
				addressArray[5] = "true";
			} else {
				addressArray[5] = "false";
			}
			
			newAddresses.add(addressArray);
		}
	}
	
	/**
	 * Returns addressList, an ArrayList of Address objects
	 * @return addressList
	 */
	public ArrayList<Address> getAddressList()
	{
		return addressList;
	}
}