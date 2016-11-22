package lab;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SpringboxCatalogApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Rule
	public JUnitRestDocumentation restDocumentation =
			new JUnitRestDocumentation("target/generated-snippets");
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(documentationConfiguration(restDocumentation)).build();
	}

	@Test
	public void movies() throws Exception {
		mvc.perform(get("/movies")).andExpect(status().isOk()).andDo(document("movies-list",
				links(
						linkWithRel("self").description("Canonical link for this resource"),
						linkWithRel("profile").description("The ALPS profile for this resource"),
						linkWithRel("first").description("The first page for this resource"),
						linkWithRel("next").description("The next page for this resource"),
						linkWithRel("last").description("The last for this resource")),
				responseFields(
						fieldWithPath("_embedded.movies").description("An array of <<movie, Movie resources>>"),
						fieldWithPath("page").description("An array of <<movie, Movie resources>>"),
						fieldWithPath("_links").description("<<movies-links, Links>> to other resources"))));
	}

	@Test
	public void genres() throws Exception {
		mvc.perform(get("/genres")).andExpect(status().isOk()).andDo(document("genres"));
	}

	@Test
	public void findByMlId() throws Exception {
		mvc.perform(get("/movies/{id}", 1000)).andExpect(status().isOk()).andDo(document("movie", 
				links(
						linkWithRel("self").description("Canonical link for this <<movie,movie>>"),
						linkWithRel("movie").description("This <<movie,movie>>"),
						linkWithRel("genres").description("The <<movie-genres,genres>> that have this genre")),
				responseFields(
						fieldWithPath("title").description("The title of the movie"),
						fieldWithPath("mlId").description("The movie lens Id"),
						fieldWithPath("numberInStock").description("The number of movies available in stock"),
						fieldWithPath("_links").description("<<movie-links,Links>> to other resources"))));

//		mvc.perform(get("/movies/{mlId}", 1000)).andExpect(status().isOk());
	}

}

