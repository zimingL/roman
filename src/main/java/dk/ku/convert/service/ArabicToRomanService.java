package dk.ku.convert.service;

import java.util.HashMap;

public class ArabicToRomanService {
	public boolean isLegalLetter(String romanN) {
		boolean isValidate = true;
		HashMap<Character, Integer>romanMap = new HashMap<Character, Integer>(); // a map that contains all letters in Roman numeral
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		for (int i = 0; i < romanN.length(); i++) {
			if (!romanMap.containsKey(romanN.charAt(i))){
				isValidate = false;
				break;
				}
		}
		return isValidate;		
	}
	
	public boolean isInRightOrder(String romanN) {
		boolean isValidate = false;
		return isValidate;
		
	}

	public String convert(Integer input) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
