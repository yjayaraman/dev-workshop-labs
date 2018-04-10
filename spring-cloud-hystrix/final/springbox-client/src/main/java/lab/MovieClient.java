package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class MovieClient {

	static final String STR= "{ \"_embedded\": {  \"movies\": [       {       \"title\": \"Backup Movie\", \"mlId\": \"1\",       \"numberInStock\": \"0\",  \"_links\":  {      \"self\":  {      \"href\": \"https://springbox-catalog-equivalve-matelot.cfapps.mag.perfexel.com/movies/1000\"  }  }}]}}";
			//"{  \"_embedded\": { 	 \"movies\": [   {  \"title\": \"Backup Movie\", \"mlId\": \"1\", \"numberInStock\": \"0\" ] }}";


	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	

//	@HystrixCommand(fallbackMethod = "getDefaultMovies", commandProperties = {
//	@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
//	@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
//	@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
//	@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, threadPoolProperties = {
//	@HystrixProperty(name = "coreSize", value = "30") })
	@HystrixCommand(fallbackMethod = "getDefaultMovies")
	String getMovies() {
		return restTemplate.getForObject("//SPRINGBOX-CATALOG/movies", String.class);
	}

	String getDefaultMovies() {
		return STR;	
	}
}
