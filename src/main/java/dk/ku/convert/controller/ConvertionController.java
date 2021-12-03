package dk.ku.convert.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dk.ku.convert.customizedException.InputOutOfRangeException;
import dk.ku.convert.customizedException.InputWrongFormatException;
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
		try {
			return romanToArabicService.convert(romanN);
		}
		catch(InputWrongFormatException ex){
		//	throw new ResponseStatusException(
		//	          HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
			throw ex;
		}
}

	@PostMapping("/arabictoroman")
	public @ResponseBody String roman(@RequestParam Integer arabicN) {
		//TODO logging
		try {
			return arabicToRomanService.convert(arabicN);
		}
		catch(InputOutOfRangeException ex){
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
		}
	}
}

