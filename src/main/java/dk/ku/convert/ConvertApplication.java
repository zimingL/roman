package dk.ku.convert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConvertApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertApplication.class, args);
		}
	

}