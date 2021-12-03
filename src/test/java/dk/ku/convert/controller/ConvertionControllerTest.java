package dk.ku.convert.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvertionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testArabicToRomanApiOK() throws Exception {
	//	MvcResult result = this.mockMvc
		this.mockMvc
		.perform(post("/v1/convertion/romantoarabic").param("romanN", "fortytwo"))
		.andExpect(status().isOk());
		//.andReturn();
		//String content = result.getResponse().getContentAsString();
		//assertThat(content).isEqualTo("fortytwo");
	}

	@Test
	public void testRomanToArabicApiOK() throws Exception {
	//	MvcResult result = this.mockMvc
		this.mockMvc
		.perform(post("/v1/convertion/arabictoroman").param("arabicN", "42"))
		.andExpect(status().isOk());
		// .andReturn();
//		String content = result.getResponse().getContentAsString();
//		assertThat(content).isEqualTo("42");
	}

}