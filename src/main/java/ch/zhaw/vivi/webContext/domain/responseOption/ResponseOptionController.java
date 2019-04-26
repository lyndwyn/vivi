package ch.zhaw.vivi.webContext.domain.responseOption;

import java.util.List;

import javax.validation.Valid;

import ch.zhaw.vivi.webContext.domain.responseOption.dto.ResponseOptionMapper;
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

import ch.zhaw.vivi.webContext.domain.responseOption.dto.ResponseOptionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity answer.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/responseOptions")
@Api(
		value = "ResponseOption",
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
public class ResponseOptionController {
	
	private ResponseOptionService answerService;
	
	private ResponseOptionMapper answerMapper;
	
	public ResponseOptionController() {}
	
	@Autowired
	public ResponseOptionController(ResponseOptionService answerService, ResponseOptionMapper answerMapper) {
		this.answerService = answerService;
		this.answerMapper = answerMapper;
	}
	
	/**
	 * This method returns the requested answer
	 * 
	 * @param id	Id of the requested answer
	 * @return		ResponseEntity with the answer that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested answer",
			response = ResponseOption.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested answer",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<ResponseOptionDTO> getById(@PathVariable Long id) {
		ResponseOption answer = answerService.findById(id);
		return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.OK);
	}
	
	/**
	 * This method returns all answers
	 * 
	 * @return		ResponseEntity with all exsisting answers
	 */
	@ApiOperation(
			value = "This endpoint returns all answers",
			response = ResponseOption.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<ResponseOptionDTO>> getAll() {
		List<ResponseOption> answers = answerService.findAll();
		return new ResponseEntity<>(answerMapper.toDTOs(answers), HttpStatus.OK);
	}
	
	/**
	 * This method creates an answer
	 * 
	 * @return		ResponseEntity with the answer that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an answer",
		response = ResponseOption.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The answer to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<ResponseOptionDTO> create(@Valid @RequestBody ResponseOptionDTO answerDTO) {
		
		// ensure answerID is null
		answerDTO.setId(null);
		
		// save answer
		ResponseOption answer = answerMapper.fromDTO(answerDTO);
		answerService.save(answer);
		return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the answer which will get updated
	 * @param answer	Updated answer
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested answer",
			response = ResponseOption.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current answer",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<ResponseOptionDTO> updateById(@PathVariable Long id, @Valid @RequestBody ResponseOptionDTO answerDTO) {
		
		// ensure ID's are the same
		answerDTO.setId(id);
		
		// update entity
		ResponseOption answer = answerMapper.fromDTO(answerDTO);
		answerService.update(answer);
			return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested answer
	 *
	 * @param  id Id of the answer that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested answer",
		response = ResponseOption.class
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