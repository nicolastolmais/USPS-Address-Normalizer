package edu.truman.cs370.team5;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Address_Processor_TestClass {
	private ArrayList<String[]> addressesList;
	private AddressProcessor aProcessor;
	@Before
	public void setUp() throws Exception {
		addressesList = new ArrayList<String[]>();
		String[] addressesArray = {"1234 Joe ln","Kirksville","MO","63501","1234"};
		addressesList.add(addressesArray);
		aProcessor = new AddressProcessor(addressesList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestConstructor() 
	{		
		assertNotNull("Error! Address Array does not exist", aProcessor.getAddresses());
	}
	
	@Test
	public void TestGetAddresses()
	{	
		ArrayList<String[]> returnedAddressesList = aProcessor.getAddresses();
		
		boolean notEqualsFlag = false;
		for(int i=0; i < addressesList.size(); i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(!(addressesList.get(i)[j].equals(returnedAddressesList.get(i)[j])))
				{
					notEqualsFlag = true;
				}
			}
		}
		assertFalse("Error! Arraylists do not match", notEqualsFlag);	
	}
	
	@Test
	public void TestGetAddressList()
	{
		aProcessor.process();
		assertNotNull("Error! addressList does not exist", aProcessor.getAddressList());
	}
	
	@Test
	public void testProcess()
	{
		aProcessor.process();
		Address testAddress = new Address("1234 Joe ln","Kirksville","MO","63501","1234");
		boolean equals = testAddress.equals(aProcessor.getAddressList().get(0));
		assertTrue("Process changed data", equals);
	}
}
