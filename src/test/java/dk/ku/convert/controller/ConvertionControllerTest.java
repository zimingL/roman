package dk.ku.convert.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvertionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testArabicToRomanApiOK() throws Exception {
		MvcResult result = this.mockMvc
			.perform(post("/toroman").param("input", "fortytwo"))
			.andExpect(status().isOk())
			.andReturn();
		String content = result.getResponse().getContentAsString();
	//	assertThat(content).isEqualTo("fortytwo");
	}
	
	@Test
	public void testRomanToArabicApi() throws Exception {
		MvcResult result = this.mockMvc
			.perform(post("/toarabic").param("input", "42"))
			.andExpect(status().isOk())
		 .andReturn();
		String content = result.getResponse().getContentAsString();
		//assertThat(content).isEqualTo("42");
	}
}