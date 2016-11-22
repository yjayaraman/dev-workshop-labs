package lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MovieController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping("/")
	public String greet() {
	    return greetingService.getGreeting();
	}
}