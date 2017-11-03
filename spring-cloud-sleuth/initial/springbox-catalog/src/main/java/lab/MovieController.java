package lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.repositories.MovieRepository; 

@RestController
public class MovieController {
	@Value("${greeting}")
	private String greeting;
	@Autowired
	MovieRepository movieRepository;

	private static Logger LOG = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping("/")
	public String greet() {
		return greeting;
	}

}
