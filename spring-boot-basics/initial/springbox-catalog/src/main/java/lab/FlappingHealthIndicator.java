package lab;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class FlappingHealthIndicator implements HealthIndicator{
	
	private Random r = new Random(System.currentTimeMillis());

	@Override
	public Health health() {
		if (r.nextInt(10) > 5)
			return Health.down().withDetail("flapper", "failure").build();
		else
			return Health.up().withDetail("flapper", "success").build();
	}

}
