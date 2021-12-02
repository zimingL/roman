package dk.ku.convert;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class ValidationServiceTest {
	private static ValidationService validationservice = null;  // ###########################static???
	
	@BeforeAll
	public static void setup() {
		validationservice = new ValidationService();
	}
	
	@Test
	void toArabicInScope() {
		assertEquals(true,validationservice.toArabicValidationService(1));  //####################why warning??
		assertEquals(false, validationservice.toArabicValidationService(0));
		assertEquals(false, validationservice.toArabicValidationService(4000));
		assertEquals(false, validationservice.toArabicValidationService(-1));
		assertEquals(true, validationservice.toArabicValidationService(1903));
	}
	
	@Test
	void toRomanLetterInScope() {
		assertEquals(true,validationservice.toRomanValidationService("IX"));  	//9
		assertEquals(true,validationservice.toRomanValidationService("MCMXCVII")); // 1997
		assertEquals(false,validationservice.toRomanValidationService("IX2")); //with a wrong letter '2'
		assertEquals(false,validationservice.toRomanValidationService("MCMSXCVII"));// with a wrong letter 'S'
	//	assertEquals(false,validationservice.toRomanValidationService(""));// ####################empty string
	}
	
}
