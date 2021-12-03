package dk.ku.convert.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvertionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRomanToArabicApiOK() throws Exception {
		this.mockMvc
		.perform(post("/v1/convertion/romantoarabic").param("romanN", "I"))
		.andExpect(status().isOk());
	}

	@Test
	public void testArabicToRomanApiOK() throws Exception {
		this.mockMvc
		.perform(post("/v1/convertion/arabictoroman").param("arabicN", "42"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testRomanToArabicApiNotOK() throws Exception {
		this.mockMvc
		.perform(post("/v1/convertion/romantoarabic").param("romanN", "ID"))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void testArabicToRomanApiNotOK() throws Exception {
		this.mockMvc
		.perform(post("/v1/convertion/arabictoroman").param("arabicN", "0"))
		.andExpect(status().isBadRequest());
	}

}