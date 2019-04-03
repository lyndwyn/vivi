package ch.zhaw.vivi.webContext.domain.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds the endpoints is responsible for users
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "UserController",
		description = "This class holds all REST endpoints targeted towards the entity user",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
@PreAuthorize("hasAuthority('READ')")
public class UserController {
	
	private UserService userService;
	
	/**
	 * 
	 */
	public UserController() {
		
	}
	
	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * This method returns the requested user
	 * 
	 * @param id	Id of the requested user
	 * @return		ResponseEntity with the user that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested user",
			response = User.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested user",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * This method returns all users
	 * 
	 * @return		ResponseEntity with all exsisting users
	 */
	@ApiOperation(
			value = "This endpoint returns all users",
			response = User.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	/**
	 * This method creates an user
	 * 
	 * @return		ResponseEntity with the user that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an user",
		response = User.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The user to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the user which will get updated
	 * @param user	Updated user
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested user",
			response = User.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The logged in user",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<User> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
			userService.update(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested user
	 *
	 * @param  id Id of the user that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested user",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested user",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
