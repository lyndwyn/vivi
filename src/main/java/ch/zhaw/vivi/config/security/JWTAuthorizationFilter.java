package ch.zhaw.vivi.config.security;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.zhaw.vivi.webContext.domain.user.UserDetailsImpl;
import ch.zhaw.vivi.webContext.domain.user.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
 * This class handles the authorization and JWT parsing process
 *
 * @author Yves Kaufmann
 */
class JWTAuthorizationFilter extends OncePerRequestFilter {

	private UserService userService;

	private Properties properties;

	/**
	 *
	 * @param userService
	 * @param properties
	 */
	JWTAuthorizationFilter(UserService userService, Properties properties) {
		this.userService = userService;
		this.properties = properties;
	}

	/**
	 * This method aligns and compares header with internal properties
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// read header
		String header = req.getHeader(properties.getProperty("jwt.header-string"));
		
		if (header != null && header.startsWith(properties.getProperty("jwt.token-prefix"))) {
			// parse header with getAuthentication and add to security context
			SecurityContextHolder.getContext().setAuthentication(getAuthentication(req, header));
		}
		
		// invoke filter chain
		chain.doFilter(req, res);
	}

	/**
	 * This method parses JWT and puts content into an authenticationToken
	 *
	 * @param req    Client request
	 * @param header Header string
	 * @return UsernamePasswordAuthenticationToken
	 */
	private Authentication getAuthentication(HttpServletRequest req, String header) {
		Long subject;
		try {
			// read subject from JWT
			var subjectString = Jwts.parser().setSigningKey(properties.getProperty("jwt.secret").getBytes())
					.parseClaimsJws(header.replace(properties.getProperty("jwt.token-prefix"), "")).getBody()
					.getSubject();
			
			subject = Long.parseLong(subjectString);
		} catch (ExpiredJwtException ex) {
			// TODO login should go here (not actually a todo but became necessary when
			// logging was removed for simplicity sake (for the uk))
			return null;
		}

		if (subject != null) {
			// read user with specified id from db and wrap in userdetails
			UserDetailsImpl userDetails = new UserDetailsImpl(userService.findById(subject));
			
			// return auth token
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		} else { // subject was not present (eclipse is wrong about the dead code)
			return null;
		}
	}

}