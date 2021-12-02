package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArabicToRomanServiceTest {
	private static ArabicToRomanService arabicToRomanService = null;  
	
	@BeforeAll
	public static void setup() {
		arabicToRomanService = new ArabicToRomanService();
	}
	@Test
	void toRomanWithLegalLetter() {
		assertEquals(true,arabicToRomanService.isLegalLetter("IX"));  	//9
		assertEquals(true,arabicToRomanService.isLegalLetter("MCMXCVII")); // 1997
		assertEquals(false,arabicToRomanService.isLegalLetter("IX2")); //with a wrong letter '2'
		assertEquals(false,arabicToRomanService.isLegalLetter("MCMSXCVII"));// with a wrong letter 'S'
	//	assertEquals(false,validationservice.isLegalLetter(""));// ####################empty string
	}
	
	@Test	
	void toRomanInRightOrder() {
		assertEquals(false,arabicToRomanService.isInRightOrder("XI")); //Wrong order, 'IX'
		assertEquals(true,arabicToRomanService.isInRightOrder("MCMIII"));//1903
		assertEquals(true,arabicToRomanService.isInRightOrder("MMCIII"));//Wrong order, 'MCMIII'
		assertEquals(false,arabicToRomanService.isInRightOrder("MCMXCVII"));//1997
		assertEquals(false,arabicToRomanService.isInRightOrder("MCMXCIVI"));//Wrong order, 'MCMXCVII'
		assertEquals(false,arabicToRomanService.isInRightOrder("MMCXCVII"));//Wrong order, 'MCMXCVII'
	}
}
