package dk.ku.convert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private ToArabicController arabicController;
	
	@Autowired
	private ToRomanController romanController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(arabicController).isNotNull();
		assertThat(romanController).isNotNull();
	}
}