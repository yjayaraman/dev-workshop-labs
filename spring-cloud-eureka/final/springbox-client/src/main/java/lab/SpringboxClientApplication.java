package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lab.domain.Movie;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@RestController

public class SpringboxClientApplication {
	
	@Autowired
	private MovieClient movieClient;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringboxClientApplication.class, args);
	}
	
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
	@RequestMapping("/movies")
	public String movies() {
		return movieClient.getMovies();
	}
	
	@RequestMapping("/backendurl")
	public String backendUrl() {
		return movieClient.getBackendUri();
	}
	
	@RequestMapping(name="/movies2", method = RequestMethod.GET, produces = {"application/json"})
	public PagedResources<Movie> movies2() {
		return movieClient.getMovies2();
	}
}

