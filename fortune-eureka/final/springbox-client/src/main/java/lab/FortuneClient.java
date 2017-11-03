package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lab.domain.Fortune;

@Component
public class FortuneClient {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	LoadBalancerClient loadBalancer;

	Fortune getRandomFortune() {
		return restTemplate.getForObject("//FORTUNE-SERVICE/random", Fortune.class);
	}


    private Fortune fallbackFortune() {
        return new Fortune(42L, "Your future is unclear.");
    }
}
