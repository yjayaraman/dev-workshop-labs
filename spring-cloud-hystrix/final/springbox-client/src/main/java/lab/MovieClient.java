package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class MovieClient {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	LoadBalancerClient loadBalancer;

	@HystrixCommand(fallbackMethod = "getDefaultMovies", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "30"),
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
	String getMovies() {
		return restTemplate.getForObject("//SPRINGBOX-CATALOG/movies", String.class);
	}

	String getDefaultMovies() {
		return "{movies: \"dummy\"}";
	}
}
