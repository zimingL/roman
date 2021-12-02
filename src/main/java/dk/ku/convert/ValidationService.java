package dk.ku.convert;

import java.util.HashMap;

public class ValidationService {
	public static boolean toArabicValidationService(Integer arabicN) {
		boolean isValidate = true;
		if (!(arabicN > 0 && arabicN < 4000))
			isValidate = false;
		return isValidate;		
	} 
	
	public static boolean toRomanValidationService(String romanN) {
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
	
}
