package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	@Autowired
	ProducerClient producerClient;
	
	 @RequestMapping(value = "/", produces = "application/json")
	 String consume() {
		 return String.format("{\"value\":%s}", producerClient.getValue());
	 }


//	 @Autowired
//	 private DiscoveryClient discoveryClient;

	// @Autowired
	// private LoadBalancerClient loadBalancerClient;

//	@Autowired
//	private RestTemplate restTemplate;

//	 @RequestMapping(value = "/", produces = "application/json")
//	 String consume() {
//	 InstanceInfo instance =
//	 discoveryClient.getNextServerFromEureka("PRODUCER", false);
//	
//	 RestTemplate restTemplate = new RestTemplate();
//	 ProducerResponse response =
//	 restTemplate.getForObject(instance.getHomePageUrl(),
//	 ProducerResponse.class);
//	
//	 return String.format("{\"value\":%d}", response.getValue());
//	 }

	// @RequestMapping(value = "/", produces = "application/json")
	// String consume() {
	// ServiceInstance instance = loadBalancerClient.choose("PRODUCER");
	// URI producerUri = URI.create(String.format("http://%s:%d",
	// instance.getHost(), instance.getPort()));
	//
	// RestTemplate restTemplate = new RestTemplate();
	// ProducerResponse response = restTemplate.getForObject(producerUri,
	// ProducerResponse.class);
	//
	// return String.format("{\"value\":%d}", response.getValue());
	// }

//	@RequestMapping(value = "/", produces = "application/json")
//	String consume() {
//		ProducerResponse response = restTemplate.getForObject("http://producer",
//				ProducerResponse.class);
//
//		return String.format("{\"value\":%d}", response.getValue());
//	}

}
