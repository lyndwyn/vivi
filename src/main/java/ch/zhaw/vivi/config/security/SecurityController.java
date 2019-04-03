package ch.zhaw.vivi.config.security;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.vivi.webContext.domain.user.User;

@RestController("/login")
public class SecurityController {
	@PostMapping({"", "/"})
	public ResponseEntity<String> login(@RequestBody User user) {
		// eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1IiwiZXhwIjoxNTU0MzEyNzMwfQ.H0fNEh7IlNAZWvRv2zy-2pYdyOPxRk9Afo6uvwLXex3KycCzMI3CUNCZb3OWbwWEbPEkYFOV5iZ37KHb_5ET-A
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1IiwiZXhwIjoxNTU0MzEyNzMwfQ.H0fNEh7IlNAZWvRv2zy-2pYdyOPxRk9Afo6uvwLXex3KycCzMI3CUNCZb3OWbwWEbPEkYFOV5iZ37KHb_5ET-A");
		responseHeaders.set("Baeldung-Example-Header",
				"Value-ResponseEntityBuilderWithHttpHeaders");

		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body("Response with header using ResponseEntity");
	} 
}
