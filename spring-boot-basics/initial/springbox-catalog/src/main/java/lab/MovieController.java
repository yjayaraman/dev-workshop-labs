package lab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Value("${greeting}")
	private String greeting;
	
	@Autowired
	CounterService greetingCounter;

	@RequestMapping("/")
	public String greet() {
		greetingCounter.increment("services.greeting.invoked.count");
		return greeting;
	}
}
