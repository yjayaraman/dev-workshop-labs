package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class SpringboxCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboxCatalogApplication.class, args);
	}
}
