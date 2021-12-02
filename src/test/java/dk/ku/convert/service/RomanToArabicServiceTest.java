package dk.ku.convert.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class RomanToArabicServiceTest {
	private static RomanToArabicService romanToArabicService = null;  // ###########################static???
	
	@BeforeAll
	public static void setup() {
		romanToArabicService = new RomanToArabicService();
	}
	
	@Test
	void toArabicInScope() {
		assertEquals(true,romanToArabicService.isInRightScope(1));  //####################why warning??
		assertEquals(false, romanToArabicService.isInRightScope(0));
		assertEquals(false, romanToArabicService.isInRightScope(4000));
		assertEquals(false, romanToArabicService.isInRightScope(-1));
		assertEquals(true, romanToArabicService.isInRightScope(1903));
	}
	

}
