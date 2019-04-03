package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.webContext.domain.completedExam.dto.CompletedExamDTO;
import ch.zhaw.vivi.webContext.domain.completedExam.dto.CompletedExamMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class holds all REST endpoints targeted towards the entity completedExam.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/completedExam")
@Api(
		value = "CompletedExamController",
		description = "This class holds all REST endpoints targeted towards the entity completedExam",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class CompletedExamController {
	
	private CompletedExamService completedExamService;

	private CompletedExamMapper completedExamMapper;

	public CompletedExamController() {}

	@Autowired
	public CompletedExamController (CompletedExamService completedExamService, CompletedExamMapper completedExamMapper) {
		this.completedExamService = completedExamService;
		this.completedExamMapper = completedExamMapper;
	}

	/**
	 * This method returns the requested completedExam
	 *
	 * @param id	Id of the requested completedExam
	 * @return		ResponseEntity with the completedExam that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested completedExam",
			response = CompletedExamDTO.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested completedExam",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<CompletedExamDTO> getById(@PathVariable Long id) {
		CompletedExam completedExam = completedExamService.findById(id);
			return new ResponseEntity<>(completedExamMapper.toDTO(completedExam), HttpStatus.OK);
	}

	/**
	 * This method returns all completedExams
	 *
	 * @return		ResponseEntity with all exsisting completedExams
	 */
	@ApiOperation(
			value = "This endpoint returns all completedExams",
			response = CompletedExam.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<CompletedExamDTO>> getAll() {
		List<CompletedExam> completedExams = completedExamService.findAll();
			return new ResponseEntity<>(completedExamMapper.toDTOs(completedExams), HttpStatus.OK);
	}

	/**
	 * This method creates an completedExam
	 *
	 * @return		ResponseEntity with the completedExam that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an completedExam",
		response = CompletedExam.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The completedExam to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<CompletedExamDTO> create(@Valid @RequestBody CompletedExamDTO completedExamDTO) {

		// ensure completedExamID is null
		completedExamDTO.setId(null);

		// save completedExam
		CompletedExam completedExam = completedExamMapper.fromDTO(completedExamDTO);
		completedExamService.save(completedExam);
			return new ResponseEntity<>(completedExamMapper.toDTO(completedExam), HttpStatus.CREATED);
	}

	/**
	 *
	 * @param id	Id from the completedExam which will get updated
	 * @param completedExamDTO	Updated completedExam
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested completedExam",
			response = CompletedExam.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current completedExam",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<CompletedExamDTO> updateById(@PathVariable Long id, @Valid @RequestBody CompletedExamDTO completedExamDTO) {

		// ensure ID's are the same
		completedExamDTO.setId(id);

		// update entity
		CompletedExam completedExam = completedExamMapper.fromDTO(completedExamDTO);
		completedExamService.update(completedExam);
			return new ResponseEntity<>(completedExamMapper.toDTO(completedExam), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested completedExam
	 *
	 * @param  id Id of the completedExam that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested completedExam",
		response = CompletedExam.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested completedExam",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		completedExamService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
