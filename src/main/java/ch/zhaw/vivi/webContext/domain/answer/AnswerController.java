package ch.zhaw.vivi.webContext.domain.answer;

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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity answer.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/answer")
@Api(
		value = "AnswerController",
		description = "This class holds all REST endpoints targeted towards the entity answer",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class AnswerController {
	
	private AnswerService answerService;
	
	public AnswerController() {}
	
	@Autowired
	public AnswerController (AnswerService answerService) {
		this.answerService = answerService;
	}
	
	/**
	 * This method returns the requested answer
	 * 
	 * @param id	Id of the requested answer
	 * @return		ResponseEntity with the answer that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested answer",
			response = Answer.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested answer",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<Answer> getById(@PathVariable Long id) {
		Answer answer = answerService.findById(id);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
	 * This method returns all answers
	 * 
	 * @return		ResponseEntity with all exsisting answers
	 */
	@ApiOperation(
			value = "This endpoint returns all answers",
			response = Answer.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<Answer>> getAll() {
		List<Answer> answers = answerService.findAll();
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	/**
	 * This method creates an answer
	 * 
	 * @return		ResponseEntity with the answer that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an answer",
		response = Answer.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The answer to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<Answer> create(@Valid @RequestBody Answer answer) {
		answerService.save(answer);
		return new ResponseEntity<>(answer, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the answer which will get updated
	 * @param answer	Updated answer
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested answer",
			response = Answer.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current answer",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<Answer> updateById(@PathVariable Long id, @Valid @RequestBody Answer answer) {
		answerService.update(answer);
			return new ResponseEntity<>(answer, HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested answer
	 *
	 * @param  id Id of the answer that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested answer",
		response = Answer.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested answer",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		answerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
