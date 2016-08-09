package lab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import lab.SpringboxConsumerApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringboxConsumerApplication.class)
@WebAppConfiguration
public class SpringboxConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
