package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArabicToRomanServiceTest {
	private static ArabicToRomanService arabicToRomanService = null;  
	
	@BeforeAll
	public static void setup() {
		arabicToRomanService = new ArabicToRomanService();
	}
	
	@AfterAll
	public static void cleanUp() {
		arabicToRomanService = null;
	}
	
	
	@Test
	void toRomanWithLegalLetter() {
		assertEquals(true,arabicToRomanService.isLegal("IX"));  	//9
		assertEquals(true,arabicToRomanService.isLegal("MCMXCVII")); // 1997
		assertEquals(false,arabicToRomanService.isLegal("IX2")); //with a wrong letter '2'
		assertEquals(false,arabicToRomanService.isLegal("MCMSXCVII"));// with a wrong letter 'S'
	}
	
	@Test
	void toRomanInRightOrder() {
		assertEquals(true,arabicToRomanService.isLegal("MCMXCVII"));//1997
		assertEquals(true,arabicToRomanService.isLegal("MCMIII"));//1903
		assertEquals(false,arabicToRomanService.isLegal("CMC"));//Wrong
		assertEquals(false,arabicToRomanService.isLegal("MCDM"));//Wrong , should be MMCD 	
		assertEquals(false,arabicToRomanService.isLegal("CCD"));//Wrong , should be MMCD 	
	}
	
	@Test
	void toRomanFollowRepeatRule() {
		assertEquals(false,arabicToRomanService.isLegal("MCMIIII"));//wrong: IIII
		assertEquals(true,arabicToRomanService.isLegal("MCMII"));//
	}
	

}
