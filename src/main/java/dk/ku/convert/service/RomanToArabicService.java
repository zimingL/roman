package dk.ku.convert.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dk.ku.convert.customizedException.InputWrongFormatException;

public class RomanToArabicService {
	public boolean isLegal(String romanN) {
		boolean isValidate = true;
		Pattern pattern = Pattern.compile("^((?=[MDCLXVI])M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3}))|M{4}$");
	  //Pattern pattern = Pattern.compile("^(?=[MDCLXVI])M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");  ///########shoudl inclide 4000!
	    Matcher matcher = pattern.matcher(romanN);
	    isValidate = matcher.matches();
		return isValidate;		
	}

	public Integer convert(String romanN) {
		if(!this.isLegal(romanN))
			throw new InputWrongFormatException("Input is in wrong format");
		Integer result = 0;
		HashMap<Character, Integer>romanMap = new HashMap<Character, Integer>(); // a map that contains all letters in Roman numeral
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		for(int i = 0; i < romanN.length(); i++) {
			if (i == romanN.length() - 1) {
				result += romanMap.get(romanN.charAt(i));
				break;
			}
			if (romanMap.get(romanN.charAt(i)) >= romanMap.get(romanN.charAt(i + 1)) ) {
				result += romanMap.get(romanN.charAt(i));
			}
			else if(romanMap.get(romanN.charAt(i)) < romanMap.get(romanN.charAt(i + 1)) ) {
				result = result - romanMap.get(romanN.charAt(i)) + romanMap.get(romanN.charAt(i + 1));
				i++;
			}
		}
		return result;
	}
	
}
