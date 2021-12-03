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
	void arabicToRomanInputInScope() {
		assertEquals(true,arabicToRomanService.isLegal(1));
		assertEquals(false, arabicToRomanService.isLegal(0));
		assertEquals(false, arabicToRomanService.isLegal(4000));
		assertEquals(false, arabicToRomanService.isLegal(-1));
		assertEquals(true, arabicToRomanService.isLegal(1903));
	}
	
	@Test
	void ArabicToRomanConvertTest() {
		assertEquals("I",arabicToRomanService.convert(1));
		assertEquals("IV",arabicToRomanService.convert(4));
		assertEquals("IX",arabicToRomanService.convert(9));
		assertEquals("XC",arabicToRomanService.convert(90));
		assertEquals("CM",arabicToRomanService.convert(900));
		assertEquals("MCMIII",arabicToRomanService.convert(1903));
		assertEquals("MCMXCVII",arabicToRomanService.convert(1997));

		
	}

}
