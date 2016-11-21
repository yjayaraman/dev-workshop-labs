package lab;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
@EnableOAuth2Sso
public class DemoApplication extends WebSecurityConfigurerAdapter {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	OAuth2ClientContext oauth2Context;

	public static void main(String[] args) {
		if ("true".equals(System.getenv("SKIP_SSL_VALIDATION"))) {
			SSLValidationDisabler.disableSSLValidation();
		}
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/oidc")
	public String authCode(Model model, HttpServletRequest request) throws Exception {
		OAuth2AccessToken accessToken = oauth2Context.getAccessToken();
		if (accessToken != null) {
			model.addAttribute("raw_token", oauth2Context.getAccessToken().getValue());
			model.addAttribute("access_token", toPrettyJsonString(parseToken(accessToken.getValue())));
		}
		return "oidc";
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/oidc")
		.authorizeRequests()
		.expressionHandler(new OAuth2WebSecurityExpressionHandler())
		.antMatchers("/oidc")
		.access("#oauth2.hasScope('openid')")
		.and()
		.antMatcher("/**").authorizeRequests()
		.antMatchers("/", "/error").permitAll()
		.anyRequest().authenticated()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/");
	}

	private Map<String, ?> parseToken(String base64Token) throws IOException {
		String token = base64Token.split("\\.")[1];
		return objectMapper.readValue(Base64.decodeBase64(token), new TypeReference<Map<String, ?>>() {
		});
	}

	private String toPrettyJsonString(Object object) throws Exception {
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

}
