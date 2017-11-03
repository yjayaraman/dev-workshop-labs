package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lab.domain.Fortune;

@SpringBootApplication
@EnableEurekaClient
@RestController

public class FortuneUIApplication {

	@Autowired
	private FortuneClient fortuneClient;

	public static void main(String[] args) {
		SpringApplication.run(FortuneUIApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/random")
	public Fortune randomFortune() {
		return fortuneClient.getRandomFortune();
	}

}
