package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dk.ku.convert.customizedException.InputOutOfRangeException;

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
		assertEquals(true, arabicToRomanService.isLegal(1));
		assertEquals(true,arabicToRomanService.isLegal(4));
		assertEquals(true,arabicToRomanService.isLegal(9));
		assertEquals(true,arabicToRomanService.isLegal(90));
		assertEquals(true,arabicToRomanService.isLegal(900));
		assertEquals(true, arabicToRomanService.isLegal(1903));
		assertEquals(true, arabicToRomanService.isLegal(1907));
		assertEquals(true, arabicToRomanService.isLegal(4000));
	}
	@Test
	void arabicToRomanInputNotInScope() {
		assertEquals(false,arabicToRomanService.isLegal(-1));
		assertEquals(false,arabicToRomanService.isLegal(0));
		assertEquals(false,arabicToRomanService.isLegal(4001));
	}
	
	@Test
	void arabicToRomanConvertOKTest() {
		assertEquals("I",arabicToRomanService.convert(1));
		assertEquals("IV",arabicToRomanService.convert(4));
		assertEquals("IX",arabicToRomanService.convert(9));
		assertEquals("XC",arabicToRomanService.convert(90));
		assertEquals("CM",arabicToRomanService.convert(900));
		assertEquals("MCMIII",arabicToRomanService.convert(1903));
		assertEquals("MCMXCVII",arabicToRomanService.convert(1997));
		assertEquals("MMMM",arabicToRomanService.convert(4000));
	}

	@Test
	void arabicToRomanConvertThrowExcetpionTest1() {
		InputOutOfRangeException ex = assertThrows(InputOutOfRangeException.class, ()->{
			arabicToRomanService.convert(-1);
		});
		assertEquals("Input number should between 1 and 4000.", ex.getMessage());
	}
	
	@Test
	void arabicToRomanConvertThrowExcetpionTest2() {
		InputOutOfRangeException ex = assertThrows(InputOutOfRangeException.class, ()->{
			arabicToRomanService.convert(0);
		});
		assertEquals("Input number should between 1 and 4000.", ex.getMessage());
	}

}
