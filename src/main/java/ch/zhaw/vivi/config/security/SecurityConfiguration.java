package ch.zhaw.vivi.config.security;

import java.util.Properties;

import ch.zhaw.vivi.webContext.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * This class is the main security context
 *
 * @author Yves Kaufmann
 */
@EnableWebSecurity
@PropertySource("/jwt.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// field injection bcause this class doesn't need to be tested
	@Autowired private UserService userService;

	@Autowired private BCryptPasswordEncoder pwEncoder;
	
	@Autowired @Qualifier("jwtProperties")
	private Properties properties;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// registers the UserDetailsService (used to loadByUsername) and the password
		// encoder to be used
		System.out.println(properties.getProperty("jwt.expiration-time") + "TEST");
		auth.userDetailsService(userService).passwordEncoder(pwEncoder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// create filters for later use
		var authenticationReqMatcher = new AntPathRequestMatcher("/login", "POST");
		var authenticationFilter = 
				new JWTAuthenticationFilter(authenticationManager(), properties, authenticationReqMatcher);
		
		var authorizationFilter = 
				new JWTAuthorizationFilter(userService, properties);
		
		// configure security
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/welcome", "/login", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
						"/webjars/**")
				.permitAll()
			.anyRequest().authenticated().and()
			.addFilterAfter(
					authenticationFilter,
					UsernamePasswordAuthenticationFilter.class)
			.addFilterAfter(
					authorizationFilter,
					UsernamePasswordAuthenticationFilter.class)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
