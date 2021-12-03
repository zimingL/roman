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
	void toArabicInScope() {
		assertEquals(true,romanToArabicService.isLegal(1));
		assertEquals(false, romanToArabicService.isLegal(0));
		assertEquals(false, romanToArabicService.isLegal(4000));
		assertEquals(false, romanToArabicService.isLegal(-1));
		assertEquals(true, romanToArabicService.isLegal(1903));
	}
	

}
