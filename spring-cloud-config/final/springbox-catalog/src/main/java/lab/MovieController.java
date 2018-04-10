package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MovieController {
	@Value("${greeting}")
	private String greeting;
	
	@Autowired
	CounterService counterService;
	
	@RequestMapping("/")
	public String greet() {
		counterService.increment("services.greeting.invoked");
		return greeting;
	}

}
