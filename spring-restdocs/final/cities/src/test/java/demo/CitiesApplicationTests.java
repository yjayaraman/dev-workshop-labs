package demo;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CitiesApplication.class)
@WebAppConfiguration
public class CitiesApplicationTests {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Rule
	public RestDocumentation restDocumentation= new RestDocumentation("build/doc-snippets");
	
	@Before
	public void setup() {
		mvc = webAppContextSetup(context).apply(documentationConfiguration(restDocumentation)).build();
	}

	@Test
	public void index() throws Exception{
		mvc.perform(get("/")).andExpect(status().isOk()).andDo(document("index"));
	}

	
	

}
