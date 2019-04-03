package ch.zhaw.vivi.config.security;
/*
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.zhaw.vivi.config.PropertyReader;
import ch.zhaw.vivi.webContext.domain.user.User;
import ch.zhaw.vivi.webContext.domain.user.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This class handles the user authentication and JWT generating process.
 *
 * @author Yves Kaufmann
 */
class JWTAuthenticationFilter /*extends AbstractAuthenticationProcessingFilter */{
/*
	private PropertyReader propertyReader;

	/**
	 * @param requiresAuthenticationRequestMatcher
	 * @param authenticationManager
	 * @param propertyReader
	 *
	JWTAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher,
			AuthenticationManager authenticationManager, PropertyReader propertyReader) {
		super(requiresAuthenticationRequestMatcher);
		setAuthenticationManager(authenticationManager);
		this.propertyReader = propertyReader;
	}

	/**
	 * This method attempts to login a user with the given credentials
	 *
	 * @param req Client request
	 * @param res Response to client request
	 *
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		try {
			User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
			return new AuthImpl(new UserDetailsImpl(creds));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method gets invoked in case the method attemptAuthentication
	 * successfully authenticated the given user
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 * @param auth  Authentication context that got generated in
	 *              attemptAuthentication
	 *
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		// Adds the UserDetailsImpl logic to the authenticated user
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
		User user = userDetailsImpl.getUser();
		String subject = Long.toString(5);

		// Builds the JWT
		String token = Jwts.builder().setSubject(subject)
				.setExpiration(
						new Date(System.currentTimeMillis() + propertyReader.getIntProperty("jwt.expiration-time")))
				.signWith(SignatureAlgorithm.HS512, propertyReader.getStringProperty("jwt.secret").getBytes())
				.compact();
		res.addHeader(propertyReader.getStringProperty("jwt.header-string"),
				propertyReader.getStringProperty("jwt.token-prefix") + token);
	}*/

}










































/*

class AuthImpl implements Authentication {
	
	private UserDetailsImpl det;
	
	public AuthImpl(UserDetailsImpl det) {
		super();
		this.det = det;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return det.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return det.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return det.getUser();
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return det;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return det;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
	
}*/
