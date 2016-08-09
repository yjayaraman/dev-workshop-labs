package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ProducerClient {
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="generateProducerFallback")
	public String getValue() {
		return restTemplate.getForObject("http://springbox-catalog/movies/1", String.class);
	}
	
	public String generateProducerFallback() {
		return "{ \"error\": \"Catalog Not Available\"}";
	}
	
	
}
