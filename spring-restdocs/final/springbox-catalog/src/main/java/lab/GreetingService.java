package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;
@Component
public class GreetingService {

	@Autowired
	GaugeService counterService;
	private int value;

	@Value("${greeting}")
	String greeting;

	public String getGreeting() {
		counterService.submit("counter.services.greeting.invoked", ++value);
		return greeting;
	}
}