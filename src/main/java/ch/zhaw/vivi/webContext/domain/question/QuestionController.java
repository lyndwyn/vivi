package ch.zhaw.vivi.webContext.domain.question;

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
 * This class holds all REST endpoints targeted towards the entity question.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/question")
@Api(
		value = "AnswerController",
		description = "This class holds all REST endpoints targeted towards the entity question",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class QuestionController {
	
	private QuestionService questionService;
	
	public QuestionController() {}
	
	@Autowired
	public QuestionController (QuestionService questionService) {
		this.questionService = questionService;
	}
	
	/**
	 * This method returns the requested question
	 * 
	 * @param id	Id of the requested question
	 * @return		ResponseEntity with the question that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested question",
			response = Question.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested question",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<Question> getById(@PathVariable Long id) {
		Question question = questionService.findById(id);
		return new ResponseEntity<>(question, HttpStatus.OK);
	}
	
	/**
	 * This method returns all questions
	 * 
	 * @return		ResponseEntity with all exsisting questions
	 */
	@ApiOperation(
			value = "This endpoint returns all questions",
			response = Question.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<Question>> getAll() {
		List<Question> questions = questionService.findAll();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	/**
	 * This method creates an question
	 * 
	 * @return		ResponseEntity with the question that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an question",
		response = Question.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The question to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		questionService.save(question);
		return new ResponseEntity<>(question, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the question which will get updated
	 * @param question	Updated question
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested question",
			response = Question.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current question",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<Question> updateById(@PathVariable Long id, @Valid @RequestBody Question question) {
		questionService.update(question);
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested question
	 *
	 * @param  id Id of the question that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested question",
		response = Question.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested question",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		questionService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
