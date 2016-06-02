package edu.truman.cs370.team5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Address_Test 
{
	@Before
	public void setUp() throws Exception 
	{
		
	}
	@After
	public void tearDown() throws Exception 
	{
		
	}
	@Test
	public void stateTest() 
	{
		Address testAddress = new Address(new String[] {"2309 Lee Dr","Arnold","MO","63010","9999"});
		assertEquals("Error! State did not match!", "MO", testAddress.getState());
	}
	
	@Test
	public void fieldsTest(){
		
		Address testAddress = new Address(new String[] {"2309 Lee Dr","Arnold","MO","63010","9999"});
		
		assertEquals("Error! Street Address did not match!", "2309 Lee Dr", testAddress.getStreetAddress());
		assertEquals("Error! City did not match!", "Arnold", testAddress.getCity());
		assertEquals("Error! State did not match!", "MO", testAddress.getState());
		assertEquals("Error! Zip5 did not match!", "63010", testAddress.getZipFive());
		assertEquals("Error! Zip4 did not match!", "9999", testAddress.getZipFour());
	
	}
	
	@Test
	public void fieldsTestWithArray()
	{
		String[] tAddress = {"2309 Lee Dr", "Arnold", "MO","63010", "9999"};
		Address testAddress = new Address(tAddress);
		assertEquals("Error! Street Address did not match!", "2309 Lee Dr", testAddress.getStreetAddress());
		assertEquals("Error! City did not match!", "Arnold", testAddress.getCity());
		assertEquals("Error! State did not match!", "MO", testAddress.getState());
		assertEquals("Error! Zip5 did not match!", "63010", testAddress.getZipFive());
		assertEquals("Error! Zip4 did not match!", "9999", testAddress.getZipFour());
		
	}
	
	@Test
	public void emptyFieldsTest()
	{
		String[] tAddress = {"2309 Lee Dr", "", "","63010", ""};
		Address testAddress = new Address(tAddress);
		assertEquals("Error! City did not match!", "", testAddress.getCity());
		
	}
	
}
