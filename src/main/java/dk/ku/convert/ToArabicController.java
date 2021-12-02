package dk.ku.convert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToArabicController {
	@PostMapping("/toarabic")
	public @ResponseBody String arabic() {
		return "Hello, World";
	}

}
