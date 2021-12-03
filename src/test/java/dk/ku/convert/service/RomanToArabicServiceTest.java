package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dk.ku.convert.customizedException.InputWrongFormatException;


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
	void romanToArabicInputOKTest() { 
		assertEquals(true,romanToArabicService.isLegal("I")); 	 		//1
		assertEquals(true,romanToArabicService.isLegal("IV"));  		//4
		assertEquals(true,romanToArabicService.isLegal("IX"));  		//9
		assertEquals(true,romanToArabicService.isLegal("XC"));  		//90
		assertEquals(true,romanToArabicService.isLegal("CM"));  		//900
		assertEquals(true,romanToArabicService.isLegal("MCMIII")); 	    //1903
		assertEquals(true,romanToArabicService.isLegal("MCMXCVII"));	// 1997
		assertEquals(true,romanToArabicService.isLegal("MMMM"));    	// 4000

	}
	
	@Test
	void romanToArabicInputNotOKTest() {
		assertEquals(false,romanToArabicService.isLegal("MCDM"));// M in wrong place	
		assertEquals(false,romanToArabicService.isLegal("CCD"));//	C cannot repeat
		assertEquals(false,romanToArabicService.isLegal("IX2")); //with a wrong letter '2'
		assertEquals(false,romanToArabicService.isLegal("MCMSXCVII"));// with a wrong letter 'S'
		assertEquals(false,romanToArabicService.isLegal("MMMMM"));//larger than 4000
		assertEquals(false,romanToArabicService.isLegal("MCMIIII"));//wrong: I repeat 4 times
	}
	
	@Test
	void romanToArabicConvertOKTest() {
		assertEquals(1,romanToArabicService.convert("I"));
		assertEquals(4,romanToArabicService.convert("IV"));
		assertEquals(9,romanToArabicService.convert("IX"));
		assertEquals(90,romanToArabicService.convert("XC"));
		assertEquals(900,romanToArabicService.convert("CM"));
		assertEquals(1903,romanToArabicService.convert("MCMIII"));
		assertEquals(1997,romanToArabicService.convert("MCMXCVII"));
		assertEquals(4000,romanToArabicService.convert("MMMM"));
	}
	@Test
	void romanToArabicConvertThrowExceptionTest1() {
		InputWrongFormatException ex = assertThrows(InputWrongFormatException.class, ()->{
			romanToArabicService.convert("MCDM");
		});
		assertEquals("Input is in wrong format", ex.getMessage());
	}
	@Test
	void romanToArabicConvertThrowExceptionTest2() {
		InputWrongFormatException ex = assertThrows(InputWrongFormatException.class, ()->{
			romanToArabicService.convert("IX2");
		});
		assertEquals("Input is in wrong format", ex.getMessage());
	}

}
