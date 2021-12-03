package dk.ku.convert.service;

public class ArabicToRomanService {
	public boolean isLegal(Integer arabicN) {
		boolean isValidate = true;
		if (!(arabicN > 0 && arabicN < 4000))
			isValidate = false;
		return isValidate;		
	}

	public String convert(Integer arabicN) {
		if(!this.isLegal(arabicN))
			return null;
		StringBuilder result = new StringBuilder();
		Integer times = 0;
		String[] romanLetters = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC",
				"C", "CD", "D", "CM", "M"};
		Integer[] arabicNumbers = new Integer[] {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
	            900, 1000 };
		for (int i = arabicNumbers.length - 1; i >= 0; i--) {
			times = arabicN / arabicNumbers[i];
			arabicN %= arabicNumbers[i];
			while(times > 0) {
				result.append(romanLetters[i]);
				times--;
			}
		}
		return result.toString();
		
	}
	
}
