package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringboxCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboxCatalogApplication.class, args);
	}
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello, World!";
	}
}
