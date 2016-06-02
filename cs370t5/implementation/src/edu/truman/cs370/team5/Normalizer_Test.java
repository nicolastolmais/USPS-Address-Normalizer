package edu.truman.cs370.team5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Normalizer_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() 
	{		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		assertNotNull("Error! Normalizer does not exist", norma);
	}
	
	@Test
	public void addressListExists(){
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		assertNotNull("Error! addressList does not exist", norma.getAddressList());
	}
	
	@Test
	public void normalizeStateField() {
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		assertEquals("Error! Incorrect state normalizer","MO",norma.normalizeState("mo"));
	}
	
	@Test
	public void normalizeCityField() {
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		assertEquals("Error! Incorrect state normalizer","KIRKSVILLE",norma.normalizeCity("kirksville"));
	}
	
	@Test
	public void normalizeStreetField() {
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		assertEquals("Error! Incorrect street normalizer","2107 BABLER RIDGE LANE",norma.normalizeStreet("2107 Babler Ridge Lane"));
	}
	
	@Test
	public void normalizeAddress(){
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","");
		Address expectedAddress = new Address("2309 LEE DR","ARNOLD","MO","63010","");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertTrue("Address not successfully normalized", expectedAddress.equals(resultantAddress));
	}
	
	@Test
	public void normalizeSingletonAddressList() {
		ArrayList<Address> addressList = new ArrayList<Address>();
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","");
		Address expectedAddress = new Address("2309 LEE DR","ARNOLD","MO","63010","");
		
		addressList.add(inputAddress);
		Normalizer norma = new Normalizer(addressList);
		
		
		
		ArrayList<Address> resultantList = norma.normalizeAddressList();
		Address resultantAddress = resultantList.get(0);
		
		assertTrue("Address 1 not successfully normalized",expectedAddress.equals(resultantAddress));
	}
	
	@Test
	public void normalizeMultiAddressList() {
		ArrayList<Address> addressList = new ArrayList<Address>();
		
		Address inputAddress1 = new Address("2309 lee dr","arnold","mo","63010","");
		Address inputAddress2 = new Address("2107 Babler Ridge Lane","Wildwood","mo","63038","");
		Address expectedAddress1 = new Address("2309 LEE DR","ARNOLD","MO","63010","");
		Address expectedAddress2 = new Address("2107 BABLER RIDGE LANE","WILDWOOD","MO","63038","");
		
		addressList.add(inputAddress1);
		addressList.add(inputAddress2);
		
		Normalizer norma = new Normalizer(addressList);
		
		
		
		ArrayList<Address> resultantList = norma.normalizeAddressList();
		Address resultantAddress1 = resultantList.get(0);
		Address resultantAddress2 = resultantList.get(1);
		
		assertTrue("Address 1 not successfully normalized",expectedAddress1.equals(resultantAddress1));
		assertTrue("Address 2 not successfully normalized",expectedAddress2.equals(resultantAddress2));
	}
	
	@Test
	public void checkNormalizableGoodInput() {
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","1234");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertTrue("Address is not normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	@Test
	public void checkNormalizableGoodInputNoZipFour() {
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertTrue("Address is not normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	@Test
	public void checkNormalizableBadStreet() {
		Address inputAddress = new Address("","arnold","mo","63010","");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertFalse("Address is normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	@Test
	public void checkNormalizableBadCity() {
		Address inputAddress = new Address("2309 lee dr","","mo","63010","");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertFalse("Address is normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	@Test
	public void checkNormalizableBadState() {
		Address inputAddress = new Address("2309 lee dr","arnold","","63010","");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertFalse("Address is normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	@Test
	public void checkNormalizableBadZipFive() {
		Address inputAddress = new Address("2309 lee dr","arnold","mo","","");
		
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertFalse("Address is normalizable", norma.checkIfNormalizable(resultantAddress));
	}
	
	//white box test (we have to know how it works in the code)
	@Test
	public void doesNoWorkOnNonNormalizableAddress() {
		Address inputAddress = new Address("2309 lee dr","arnold","mo","","");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertTrue("Work was done on a non-normalizable address!", resultantAddress.equals(inputAddress));
		assertFalse("Normalizable flags are the same!", resultantAddress.getNormalizableFlag() == inputAddress.getNormalizableFlag());
	}

	@Test
	public void zip5RegexInvalid(){
		Address inputAddress = new Address("2309 lee dr","arnold","mo","6301","9999");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertFalse("Address was normalized", resultantAddress.getNormalizableFlag());
	}

	@Test
	public void zip5RegexValid(){
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","9999");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertTrue("Address was not normalized", resultantAddress.getNormalizableFlag());
	}
	
	@Test
	public void normalizeInvalidZipFour(){
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","999");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertEquals("Zip4 was not normalized", "", resultantAddress.getZipFour());
	}
	
	@Test
	public void normalizeValidZipFour(){
		Address inputAddress = new Address("2309 lee dr","arnold","mo","63010","9999");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertEquals("Zip4 was incorrectly deleted", "9999", resultantAddress.getZipFour());
	}
	
	@Test
	public void normalizeStateRegex() {
		Address inputAddress = new Address("2309 lee dr","arnold","missouri","63010","9999");
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		Address resultantAddress = norma.normalizeAddress(inputAddress);
		
		assertEquals("State was incorrectly Normalized", "MO", resultantAddress.getState());
		
		Address inputMO = new Address("2309 lee dr","arnold","misSouri","63010","9999");
		Address resultantMO = norma.normalizeAddress(inputMO);
		assertEquals("State was incorrectly Normalized", "MO", resultantMO.getState());
		
		Address inputNH = new Address("2309 lee dr","arnold","new hampshire","63010","9999");
		Address resultantNH = norma.normalizeAddress(inputNH);
		assertEquals("State was incorrectly Normalized", "NH", resultantNH.getState());
		
		Address inputAE = new Address("2309 lee dr","arnold","armed forces europe, the middle east, and canada","63010","9999");
		Address resultantAE = norma.normalizeAddress(inputAE);
		assertEquals("State was incorrectly Normalized", "AE", resultantAE.getState());
		
		Address inputDC = new Address("2309 lee dr","arnold","district of columbia","63010","9999");
		Address resultantDC = norma.normalizeAddress(inputDC);
		assertEquals("State was incorrectly Normalized", "DC", resultantDC.getState());
		
		Address inputDCAbb = new Address("2309 lee dr","arnold","DC","63010","9999");
		Address resultantDCAbb = norma.normalizeAddress(inputDCAbb);
		assertEquals("State was incorrectly Normalized", "DC", resultantDCAbb.getState());
		
		Address inputDCPeriod = new Address("2309 lee dr","arnold","d.c.","63010","9999");
		Address resultantDCPeriod = norma.normalizeAddress(inputDCPeriod);
		assertEquals("State was incorrectly Normalized", "DC", resultantDCPeriod.getState());
		
		Address inputVI = new Address("2309 lee dr","arnold","virgin islands","63010","9999");
		Address resultantVI = norma.normalizeAddress(inputVI);
		assertEquals("State was incorrectly Normalized", "VI", resultantVI.getState());
		
//		Address inputBadState = new Address("2309 lee dr","arnold","asdfmower","63010","9999");
//		Address resultantBadState = norma.normalizeAddress(inputBadState);
//		assertEquals("State was incorrectly Normalized", "", resultantBadState.getState());
	}
	
	@Test
	public void checkIfStateNormalizable(){
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		
		Address inputBadState = new Address("2309 lee dr","arnold","beckshouse","63010","9999");
		Address resultantAddress = norma.normalizeAddress(inputBadState);
		assertTrue("Address was normalized when it should not have been", inputBadState.equals(resultantAddress));
		
		assertFalse("Normalizable flags should be different", inputBadState.getNormalizableFlag() == resultantAddress.getNormalizableFlag());
	}
	
	@Test
	public void normalizableCityRegex() {
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		
		Address inputAddressSaint = new Address("2309 lee dr","saint louis","mo","63010","9999");
		Address resultantAddress = norma.normalizeAddress(inputAddressSaint);
		assertTrue("saint should have been normalized to ST", resultantAddress.getCity().equals("ST LOUIS"));
		
		Address inputAddressESaint = new Address("2309 lee dr","east saint louis","mo","63010","9999");
		Address resultantAddress2 = norma.normalizeAddress(inputAddressESaint);
		assertTrue("saint should have been normalized to ST", resultantAddress2.getCity().equals("EAST ST LOUIS"));
		
		Address inputAddressCaseInsens = new Address("2309 lee dr","Saint louIs","mo","63010","9999");
		Address resultantAddressCaseInsens = norma.normalizeAddress(inputAddressCaseInsens);
		assertTrue("saint should have been normalized to ST", resultantAddressCaseInsens.getCity().equals("ST LOUIS"));
		
		Address inputAddressST = new Address("2309 lee dr","St Louis","mo","63010","9999");
		Address resultantAddressST = norma.normalizeAddress(inputAddressST);
		assertTrue("saint should have been normalized to ST", resultantAddressST.getCity().equals("ST LOUIS"));
		
		Address inputAddressSTPeriod = new Address("2309 lee dr","St. Louis","mo","63010","9999");
		Address resultantAddressSTPeriod = norma.normalizeAddress(inputAddressSTPeriod);
		assertTrue("saint should have been normalized to ST", resultantAddressSTPeriod.getCity().equals("ST LOUIS"));
	}
	
	@Test
	public void normalizableStreetAddressRegex() {
		Normalizer norma = new Normalizer(new ArrayList<Address>());
		
		Address inputAddressSaint = new Address("2309 lee st.","saint louis","mo","63010","9999");
		Address resultantAddress = norma.normalizeAddress(inputAddressSaint);
		assertTrue("st. should have been normalized to ST", resultantAddress.getStreetAddress().equals("2309 LEE ST"));
		
		Address inputAddressSaint1 = new Address("2309 lee, st","saint louis","mo","63010","9999");
		Address resultantAddress1 = norma.normalizeAddress(inputAddressSaint1);
		assertTrue("2309 lee, st should have been normalized to 2309 LEE ST", resultantAddress1.getStreetAddress().equals("2309 LEE ST"));
		
		Address inputAddressStreet = new Address("2309 lee street","saint louis","mo","63010","9999");
		Address resultantAddressStreet = norma.normalizeAddress(inputAddressStreet);
		System.out.println(resultantAddressStreet.getStreetAddress());
		assertTrue("street should have been normalized to ST", resultantAddressStreet.getStreetAddress().equals("2309 LEE ST"));
	}

}
