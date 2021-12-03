package dk.ku.convert.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicToRomanService {
	public boolean isLegal(String romanN) {
		boolean isValidate = true;
		Pattern pattern = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	    Matcher matcher = pattern.matcher(romanN);
	    isValidate = matcher.matches();
		return isValidate;		
	}
	

	public String convert(Integer input) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
