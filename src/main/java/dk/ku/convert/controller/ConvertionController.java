package dk.ku.convert.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dk.ku.convert.service.ArabicToRomanService;
import dk.ku.convert.service.RomanToArabicService;

@RestController
@RequestMapping("/v1/convertion")
public class ConvertionController {
	RomanToArabicService romanToArabicService = new RomanToArabicService();
	ArabicToRomanService arabicToRomanService = new ArabicToRomanService();
	@PostMapping("/romantoarabic")
	public @ResponseBody Integer arabic(@RequestParam String romanN) {
		//TODO logging 
		return romanToArabicService.convert(romanN);
}

	@PostMapping("/arabictoroman")
	public @ResponseBody String roman(@RequestParam Integer arabicN) {
		//TODO logging
		return arabicToRomanService.convert(arabicN);
	}
	
}

