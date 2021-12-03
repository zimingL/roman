package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class RomanToArabicServiceTest {
	private static RomanToArabicService romanToArabicService = null;  
	
	@BeforeAll
	public static void setup() {
		romanToArabicService = new RomanToArabicService();
	}
	
	@AfterAll
	public static void cleanUp() {
		romanToArabicService = null;
	}
	
	
	@Test
	void romanToRomanInputWithLegalLetter() {
		assertEquals(true,romanToArabicService.isLegal("IX"));  	//9
		assertEquals(true,romanToArabicService.isLegal("MCMXCVII")); // 1997
		assertEquals(false,romanToArabicService.isLegal("IX2")); //with a wrong letter '2'
		assertEquals(false,romanToArabicService.isLegal("MCMSXCVII"));// with a wrong letter 'S'
	}
	
	@Test
	void toRomanInputInRightOrder() {
		assertEquals(true,romanToArabicService.isLegal("MCMXCVII"));//1997
		assertEquals(true,romanToArabicService.isLegal("MCMIII"));//1903
		assertEquals(false,romanToArabicService.isLegal("CMC"));//Wrong
		assertEquals(false,romanToArabicService.isLegal("MCDM"));//Wrong , should be MMCD 	
		assertEquals(false,romanToArabicService.isLegal("CCD"));//Wrong , should be MMCD 	
	}
	
	@Test
	void toRomanInputFollowRepeatRule() {
		assertEquals(false,romanToArabicService.isLegal("MCMIIII"));//wrong: IIII
		assertEquals(true,romanToArabicService.isLegal("MCMII"));//
	}
	
	@Test
	void romanToArabicConvertTest() {
		assertEquals(1,romanToArabicService.convert("I"));
		assertEquals(4,romanToArabicService.convert("IV"));
		assertEquals(9,romanToArabicService.convert("IX"));
		assertEquals(90,romanToArabicService.convert("XC"));
		assertEquals(900,romanToArabicService.convert("CM"));
		assertEquals(1903,romanToArabicService.convert("MCMIII"));
		assertEquals(1997,romanToArabicService.convert("MCMXCVII"));
	}

}
