package dk.ku.convert.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RomanToArabicService {
	public boolean isInRightScope(Integer arabicN) {
		boolean isValidate = true;
		if (!(arabicN > 0 && arabicN < 4000))
			isValidate = false;
		return isValidate;		
	}

	public Integer convert(String romanN) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
