package ch.zhaw.vivi.webContext.domain.authority;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity authority.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/authorities")
@Api(
		value = "Address Controller",
		description = "This class holds all REST endpoints targeted towards the entity address",
		authorizations = {
				@Authorization(
					value = "predefined authorization scheme",
					scopes = {
							@AuthorizationScope(
								description = "description",
								scope = "predeclared scope"
							) }
				) }
	)
public class AuthorityController {

	private AuthorityService authorityService;
	
	
	/**
	 * 
	 */
	public AuthorityController() {}
	
	/**
	 * 
	 * @param authorityService
	 * @param authorityMapper
	 */
	@Autowired
	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	/**
	 * This method returns the requested authority
	 *
	 * @param  id Id of the requested authority
	 * @return    ResponseEntity with the authority that was requested
	 */
	@ApiOperation(
	value = "This endpoint returns the requested authority",
	response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested authority",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Authority> getById(@PathVariable long id) {
		Authority authority = authorityService.findById(id);
		return new ResponseEntity<>(authority, HttpStatus.OK);
	}
	
	/**
	 * This method returns all authorities
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all authorities",
		response = Authority.class
	)
	@GetMapping({ "", "/" })
	public ResponseEntity<Iterable<Authority>> getAll() {
		List<Authority> authorities = authorityService.findAll();
		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}
	
	/**
	 * This method creates an authority
	 *
	 * @return ResponseEntity with the authority that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an authority",
		response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The authority to be created",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<Authority> create(@Valid @RequestBody Authority authority) {
		authorityService.save(authority);
		return new ResponseEntity<>(authority, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested authority
	 *
	 * @param  id   Id of the authority that should get updated
	 * @param  authority authority entity to which the requested authority should get updated to
	 * @return      ResponseEntity with the updated authority
	 */
	@ApiOperation(
		value = "This endpoint updates the requested authority",
		response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The logged in authority",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<Authority> updateById(@PathVariable Long id, @Valid @RequestBody Authority authority) {
		authorityService.update(authority);
		return new ResponseEntity<>(authority, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested authority
	 *
	 * @param  id Id of the authority that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested authority",
		response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested authority",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		authorityService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
