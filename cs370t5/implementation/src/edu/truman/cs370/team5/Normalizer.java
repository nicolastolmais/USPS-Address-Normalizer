package edu.truman.cs370.team5;

import java.util.ArrayList;

/**
 * Normalizes the fields of an Address object according to USPS standards
 * 
 * @author CS370 TEAM 5
 *
 */
public class Normalizer {

	private ArrayList<Address> addressList;
	
	/**
	 * Constructor for the Normalizer class
	 * @param addressList, an ArrayList of Address objects
	 */
	public Normalizer(ArrayList<Address> addressList)
	{
		this.addressList = addressList;
	}
	
	/**
	 * Returns the input address list
	 * @return addressList--
	 */
	public ArrayList<Address> getAddressList() {
		return addressList;
	}
	
	
	
	/**
	 * Normalizes the state field of an address to its two-letter abbreviation.
	 * @param state, the state field of an address
	 * @return the two-letter abbreviation of the state
	 */
	public String normalizeState(String state) {
		if(state.matches("(?i:^alabama|al$)")) {
			return "AL";
		}
		else if(state.matches("(?i:^alaska|ak$)")) {
			return "AK";
		}
		else if(state.matches("(?i:^american samoa|as$)")) {
			return "AS";
		}
		else if(state.matches("(?i:^arizona|az$)")) {
			return "AZ";
		}
		else if(state.matches("(?i:^arkansas|ar$)")) {
			return "AR";
		}
		else if(state.matches("(?i:^alaska|ak$)")) {
			return "AK";
		}
		else if(state.matches("(?i:^california|ca$)")) {
			return "CA";
		}
		else if(state.matches("(?i:^colorado|co$)")) {
			return "CO";
		}
		else if(state.matches("(?i:^connecticut|ct$)")) {
			return "CT";
		}
		else if(state.matches("(?i:^delaware|de$)")) {
			return "DE";
		}
		else if(state.matches("(?i:^district of columbia|d.?c.?$)")) {
			return "DC";
		}
		else if(state.matches("(?i:^federated states of micronesia|fm$)")) {
			return "FM";
		}
		else if(state.matches("(?i:^florida|fl$)")) {
			return "FL";
		}
		else if(state.matches("(?i:^georgia|ga$)")) {
			return "GA";
		}
		else if(state.matches("(?i:^guam|gu$)")) {
			return "GU";
		}
		else if(state.matches("(?i:^hawaii|hi$)")) {
			return "HI";
		}
		else if(state.matches("(?i:^idaho|id$)")) {
			return "ID";
		}
		else if(state.matches("(?i:^illinois|il$)")) {
			return "IL";
		}
		else if(state.matches("(?i:^indiana|in$)")) {
			return "IN";
		}
		else if(state.matches("(?i:^iowa|ia$)")) {
			return "IA";
		}
		else if(state.matches("(?i:^kansas|ks$)")) {
			return "KS";
		}
		else if(state.matches("(?i:^kentucky|ky$)")) {
			return "KY";
		}
		else if(state.matches("(?i:^louisiana|la$)")) {
			return "LA";
		}
		else if(state.matches("(?i:^maine|me$)")) {
			return "ME";
		}
		else if(state.matches("(?i:^marshall islands|mh$)")) {
			return "MH";
		}
		else if(state.matches("(?i:^maryland|md$)")) {
			return "MD";
		}
		else if(state.matches("(?i:^massachusetts|ma$)")) {
			return "MA";
		}
		else if(state.matches("(?i:^michigan|mi$)")) {
			return "MI";
		}
		else if(state.matches("(?i:^minnesota|mn$)")) {
			return "MN";
		}
		else if(state.matches("(?i:^mississippi|ms$)")) {
			return "MS";
		}
		else if(state.matches("(?i:^missouri|mo$)")) {
			return "MO";
		}
		else if(state.matches("(?i:^montana|mt$)")) {
			return "MT";
		}
		else if(state.matches("(?i:^nebraska|ne$)")) {
			return "NE";
		}
		else if(state.matches("(?i:^nevada|nv$)")) {
			return "NV";
		}
		else if(state.matches("(?i:^new hampshire|nh$)")) {
			return "NH";
		}
		else if(state.matches("(?i:^new jersey|nj$)")) {
			return "NJ";
		}
		else if(state.matches("(?i:^new mexico|nm$)")) {
			return "NM";
		}
		else if(state.matches("(?i:^new york|ny$)")) {
			return "NY";
		}
		else if(state.matches("(?i:^north carolina|nc$)")) {
			return "NC";
		}
		else if(state.matches("(?i:^north dakota|nd$)")) {
			return "ND";
		}
		else if(state.matches("(?i:^northern mariana islands|mp$)")) {
			return "MP";
		}
		else if(state.matches("(?i:^ohio|oh$)")) {
			return "OH";
		}
		else if(state.matches("(?i:^oklahoma|ok$)")) {
			return "OK";
		}
		else if(state.matches("(?i:^oregan|or$)")) {
			return "OR";
		}
		else if(state.matches("(?i:^palau|pw$)")) {
			return "PW";
		}
		else if(state.matches("(?i:^pennsylvania|pa$)")) {
			return "PA";
		}
		else if(state.matches("(?i:^puerto rico|pr$)")) {
			return "PR";
		}
		else if(state.matches("(?i:^rhode island|ri$)")) {
			return "RI";
		}
		else if(state.matches("(?i:^south carolina|sc$)")) {
			return "SC";
		}
		else if(state.matches("(?i:^south dakota|sd$)")) {
			return "SD";
		}
		else if(state.matches("(?i:^tennessee|tn$)")) {
			return "TN";
		}
		else if(state.matches("(?i:^texas|tx$)")) {
			return "TX";
		}
		else if(state.matches("(?i:^utah|ut$)")) {
			return "UT";
		}
		else if(state.matches("(?i:^vermont|vt$)")) {
			return "VT";
		}
		else if(state.matches("(?i:^virgin islands|vi$)")) {
			return "VI";
		}
		else if(state.matches("(?i:^virginia|va$)")) {
			return "VA";
		}
		else if(state.matches("(?i:^washington|wa$)")) {
			return "WA";
		}
		else if(state.matches("(?i:^west virgina|wv$)")) {
			return "WV";
		}
		else if(state.matches("(?i:^wisconsin|wi$)")) {
			return "WI";
		}
		else if(state.matches("(?i:^wyoming|wy$)")) {
			return "WY";
		}
		else if(state.matches("(?i:^armed forces europe, the middle east, and canada|ae$)")) {
			return "AE";
		}
		else if(state.matches("(?i:^armed forces pacific|ap$)")) {
			return "AP";
		}
		else if(state.matches("(?i:^armed forces americas|aa$)")) {
			return "AA";
		}
		else{
			return "";
		}
	
	}
	
	/**
	 * Normalizes the city field of an address
	 * @param city, the city field of an address
	 * @return the city normalized to USPS standards
	 */
	public String normalizeCity(String city) {
		String[] cityArr;
		cityArr = city.split(" ");
		for(int i = 0; i < cityArr.length; i++){
			cityArr[i] = cityArr[i].toUpperCase();
			if(cityArr[i].matches("(?i:^saint|st.?$)")) {
				cityArr[i] = "ST";
			}
		}
		String normalizedCity = "";
		for(int i = 0; i < cityArr.length; i++) {
			if(i < cityArr.length - 1){
				normalizedCity += cityArr[i] + " ";
			} else {
				normalizedCity += cityArr[i];
			}
		}
		return normalizedCity;
	}
	
	/**
	 * Normalizes the street field of an address
	 * @param street, the street field of an address
	 * @return the street normalized to to USPS standards
	 */
	public String normalizeStreet(String street) {
		char[] streetArray = street.toCharArray();
		String normalizedStreet = "";
		String tempString = "";
		int maxStreetIndex = -1;
		String streetPattern = "(?i:^(STREET)|(strt)|(str)$)";
		
		
		for(int i = 0; i < streetArray.length; i++){
			if(!(streetArray[i] == '.' || streetArray[i] == ',')){
				tempString += streetArray[i];
			}
		}
		
		String[] splitArray = tempString.split(" ");
		
		for(int i = 0; i < splitArray.length; i++){
			if(splitArray[i].matches(streetPattern)){
				maxStreetIndex = i;
			}
		}
		
		if(maxStreetIndex >= 0){
			splitArray[maxStreetIndex] = "ST";
		}
		
		for(int i = 0; i < splitArray.length; i++) {
			if(i < splitArray.length - 1){
				normalizedStreet += splitArray[i] + " ";
			} else {
				normalizedStreet += splitArray[i];
			}
		}
		
		
		
		normalizedStreet = normalizedStreet.toUpperCase().trim();
		
		return normalizedStreet;
	}
	
	private boolean checkIfStreetNormalizable(Address address){
		if(address.getStreetAddress() == ""){
			return false;
		} else {
			return true;
		}
	}
	
	private boolean checkIfCityNormalizable(Address address){
		if(address.getCity() == ""){
			return false;
		} else {
			return true;
		}
	}
	
	private boolean checkIfStateNormalizable(Address address) {
		if (address.getState().matches("(?i:^alabama|al$)")) {
			return true;
		} else if (address.getState().matches("(?i:^alaska|ak$)")) {
			return true;
		} else if (address.getState().matches("(?i:^american samoa|as$)")) {
			return true;
		} else if (address.getState().matches("(?i:^arizona|az$)")) {
			return true;
		} else if (address.getState().matches("(?i:^arkansas|ar$)")) {
			return true;
		} else if (address.getState().matches("(?i:^alaska|ak$)")) {
			return true;
		} else if (address.getState().matches("(?i:^california|ca$)")) {
			return true;
		} else if (address.getState().matches("(?i:^colorado|co$)")) {
			return true;
		} else if (address.getState().matches("(?i:^connecticut|ct$)")) {
			return true;
		} else if (address.getState().matches("(?i:^delaware|de$)")) {
			return true;
		} else if (address.getState().matches("(?i:^district of columbia|d.?c.?$)")) {
			return true;
		} else if (address.getState().matches("(?i:^federated states of micronesia|fm$)")) {
			return true;
		} else if (address.getState().matches("(?i:^florida|fl$)")) {
			return true;
		} else if (address.getState().matches("(?i:^georgia|ga$)")) {
			return true;
		} else if (address.getState().matches("(?i:^guam|gu$)")) {
			return true;
		} else if (address.getState().matches("(?i:^hawaii|hi$)")) {
			return true;
		} else if (address.getState().matches("(?i:^idaho|id$)")) {
			return true;
		} else if (address.getState().matches("(?i:^illinois|il$)")) {
			return true;
		} else if (address.getState().matches("(?i:^indiana|in$)")) {
			return true;
		} else if (address.getState().matches("(?i:^iowa|ia$)")) {
			return true;
		} else if (address.getState().matches("(?i:^kansas|ks$)")) {
			return true;
		} else if (address.getState().matches("(?i:^kentucky|ky$)")) {
			return true;
		} else if (address.getState().matches("(?i:^louisiana|la$)")) {
			return true;
		} else if (address.getState().matches("(?i:^maine|me$)")) {
			return true;
		} else if (address.getState().matches("(?i:^marshall islands|mh$)")) {
			return true;
		} else if (address.getState().matches("(?i:^maryland|md$)")) {
			return true;
		} else if (address.getState().matches("(?i:^massachusetts|ma$)")) {
			return true;
		} else if (address.getState().matches("(?i:^michigan|mi$)")) {
			return true;
		} else if (address.getState().matches("(?i:^minnesota|mn$)")) {
			return true;
		} else if (address.getState().matches("(?i:^mississippi|ms$)")) {
			return true;
		} else if (address.getState().matches("(?i:^missouri|mo$)")) {
			return true;
		} else if (address.getState().matches("(?i:^montana|mt$)")) {
			return true;
		} else if (address.getState().matches("(?i:^nebraska|ne$)")) {
			return true;
		} else if (address.getState().matches("(?i:^nevada|nv$)")) {
			return true;
		} else if (address.getState().matches("(?i:^new hampshire|nh$)")) {
			return true;
		} else if (address.getState().matches("(?i:^new jersey|nj$)")) {
			return true;
		} else if (address.getState().matches("(?i:^new mexico|nm$)")) {
			return true;
		} else if (address.getState().matches("(?i:^new york|ny$)")) {
			return true;
		} else if (address.getState().matches("(?i:^north carolina|nc$)")) {
			return true;
		} else if (address.getState().matches("(?i:^north dakota|nd$)")) {
			return true;
		} else if (address.getState().matches("(?i:^northern mariana islands|mp$)")) {
			return true;
		} else if (address.getState().matches("(?i:^ohio|oh$)")) {
			return true;
		} else if (address.getState().matches("(?i:^oklahoma|ok$)")) {
			return true;
		} else if (address.getState().matches("(?i:^oregan|or$)")) {
			return true;
		} else if (address.getState().matches("(?i:^palau|pw$)")) {
			return true;
		} else if (address.getState().matches("(?i:^pennsylvania|pa$)")) {
			return true;
		} else if (address.getState().matches("(?i:^puerto rico|pr$)")) {
			return true;
		} else if (address.getState().matches("(?i:^rhode island|ri$)")) {
			return true;
		} else if (address.getState().matches("(?i:^south carolina|sc$)")) {
			return true;
		} else if (address.getState().matches("(?i:^south dakota|sd$)")) {
			return true;
		} else if (address.getState().matches("(?i:^tennessee|tn$)")) {
			return true;
		} else if (address.getState().matches("(?i:^texas|tx$)")) {
			return true;
		} else if (address.getState().matches("(?i:^utah|ut$)")) {
			return true;
		} else if (address.getState().matches("(?i:^vermont|vt$)")) {
			return true;
		} else if (address.getState().matches("(?i:^virgin islands|vi$)")) {
			return true;
		} else if (address.getState().matches("(?i:^virginia|va$)")) {
			return true;
		} else if (address.getState().matches("(?i:^washington|wa$)")) {
			return true;
		} else if (address.getState().matches("(?i:^west virgina|wv$)")) {
			return true;
		} else if (address.getState().matches("(?i:^wisconsin|wi$)")) {
			return true;
		} else if (address.getState().matches("(?i:^wyoming|wy$)")) {
			return true;
		} else if (address.getState().matches("(?i:^armed forces europe, the middle east, and canada|ae$)")) {
			return true;
		} else if (address.getState().matches("(?i:^armed forces pacific|ap$)")) {
			return true;
		} else if (address.getState().matches("(?i:^armed forces americas|aa$)")) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkIfZipFiveNormalizable(Address address){
		String zip5Pattern = "^\\d{5}$";
		
		if(address.getZipFive().matches(zip5Pattern)){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isZip4Valid(Address address){
		String zip4Pattern = "^\\d{4}$";
		
		if(address.getZipFour().matches(zip4Pattern)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Normalizes an address to USPS standards
	 * @param address
	 * @return an address normalized to USPS standards
	 */
	public Address normalizeAddress(Address address) {
		Address normAddress;
		
		if(checkIfNormalizable(address)){
			String street = normalizeStreet(address.getStreetAddress());
			String city = normalizeCity(address.getCity());
			String state = normalizeState(address.getState());
			String zip5 = address.getZipFive();
			String zip4 = address.getZipFour();
			
			if(isZip4Valid(address)){
				normAddress = new Address(street,city,state,zip5,zip4);
			} else {
				normAddress = new Address(street,city,state,zip5,"");
			}
			
			return normAddress;
		} else {
			String street = address.getStreetAddress();
			String city = address.getCity();
			String state = address.getState();
			String zip5 = address.getZipFive();
			String zip4 = address.getZipFour();
			normAddress = new Address(street,city,state,zip5,zip4);
			normAddress.setNormalizableFlag(false);
			return normAddress;
		}
	}
	
	/**
	 * Normalizes a list of addresses
	 * @return an ArrayList of normalized addresses
	 */
	public ArrayList<Address> normalizeAddressList(){
		ArrayList<Address> normAddressList = new ArrayList<Address>();
		for(Address address: addressList){
			normAddressList.add(normalizeAddress(address));
		}
		return normAddressList;
	}
	
	/**
	 * Determines if an address is normalizable
	 * @param address
	 * @return a boolean indicating whether an address was normalizable
	 */
	public boolean checkIfNormalizable(Address address) {
		boolean flag, streetFlag, cityFlag, stateFlag, zip5Flag;
		
		streetFlag = checkIfStreetNormalizable(address);
		cityFlag =  checkIfCityNormalizable(address);
		stateFlag = checkIfStateNormalizable(address);
		zip5Flag = checkIfZipFiveNormalizable(address);
		
		if(streetFlag && cityFlag && stateFlag && zip5Flag){
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}
	

}
