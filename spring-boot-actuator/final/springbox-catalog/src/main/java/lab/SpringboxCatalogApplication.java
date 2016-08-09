package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringboxCatalogApplication {
	
	@Autowired
	GreetingService greetingService;

	public static void main(String[] args) {
		SpringApplication.run(SpringboxCatalogApplication.class, args);
	}
	
	@RequestMapping("/")
	public String greeting() {
	    return String.format("%s World!", greetingService.getGreeting());
	}
}
