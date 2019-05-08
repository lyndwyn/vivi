package ch.zhaw.vivi.webContext.domain.ongoingExam;

import ch.zhaw.vivi.webContext.domain.ongoingExam.dto.OngoingExamDTO;
import ch.zhaw.vivi.webContext.domain.ongoingExam.dto.OngoingExamMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;

/**
 * This class holds all REST endpoints targeted towards the entity ongoingExam.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/ongoingExams")
@Api(
		value = "CompletedExamController",
		description = "This class holds all REST endpoints targeted towards the entity ongoingExam",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class OngoingExamController {
	
	private OngoingExamService ongoingExamService;

	private OngoingExamMapper ongoingExamMapper;

	public OngoingExamController() {}

	@Autowired
	public OngoingExamController (OngoingExamService ongoingExamService, OngoingExamMapper ongoingExamMapper) {
		this.ongoingExamService = ongoingExamService;
		this.ongoingExamMapper = ongoingExamMapper;
	}

	/**
	 * This method returns the requested ongoingExam
	 *
	 * @param id	Id of the requested ongoingExam
	 * @return		ResponseEntity with the ongoingExam that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested ongoingExam",
			response = OngoingExamDTO.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested ongoingExam",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<OngoingExam> getById(@PathVariable Long id) {
		OngoingExam ongoingExam = ongoingExamService.findById(id);
			return new ResponseEntity<>(ongoingExam, HttpStatus.OK);
	}

	/**
	 * This method returns all completedExams
	 *
	 * @return		ResponseEntity with all exsisting completedExams
	 */
	@ApiOperation(
			value = "This endpoint returns all completedExams",
			response = OngoingExam.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<OngoingExam>> getAll() {
		List<OngoingExam> ongoingExams = ongoingExamService.findAll();
			return new ResponseEntity<>(ongoingExams, HttpStatus.OK);
	}

	/**
	 * This method creates an ongoingExam
	 *
	 * @return		ResponseEntity with the ongoingExam that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an ongoingExam",
		response = OngoingExam.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The ongoingExam to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<OngoingExamDTO> create(@Valid @RequestBody OngoingExamDTO ongoingExamDTO) {

		// ensure completedExamID is null
		ongoingExamDTO.setId(null);


		// save ongoingExam
		OngoingExam ongoingExam = ongoingExamMapper.fromDTO(ongoingExamDTO);
		ongoingExam.setStartTime(LocalTime.now());
		ongoingExamService.save(ongoingExam);
			return new ResponseEntity<>(ongoingExamMapper.toDTO(ongoingExam), HttpStatus.CREATED);
	}

	/**
	 *
	 * @param id	Id from the ongoingExam which will get updated
	 * @param ongoingExamDTO	Updated ongoingExam
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested ongoingExam",
			response = OngoingExam.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current ongoingExam",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<OngoingExamDTO> updateById(@PathVariable Long id, @Valid @RequestBody OngoingExamDTO ongoingExamDTO) {

		// ensure ID's are the same
		ongoingExamDTO.setId(id);

		// update entity
		OngoingExam ongoingExam = ongoingExamMapper.fromDTO(ongoingExamDTO);
		ongoingExamService.update(ongoingExam);
			return new ResponseEntity<>(ongoingExamMapper.toDTO(ongoingExam), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested ongoingExam
	 *
	 * @param  id Id of the ongoingExam that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested ongoingExam",
		response = OngoingExam.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested ongoingExam",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		ongoingExamService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * This endpoint adds a response to the ongoing exam
	 *
	 * @param  id Id of the ongoingExam that should be updated
	 * @param  id Id of the given responseOption
	 * @return    ResponseEntity with the outcome of the process
	 */
	@ApiOperation(
			value = "This endpoint adds a response to the ongoing exam."
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested ongoingExam",
					required = true
			), @ApiImplicitParam(
					value = "Id of requested responseOption",
					required = true
			) }
	)
	@PutMapping("/{id}/responseOption/{respond}")
	public ResponseEntity<Void> addGivenResponseById(@PathVariable Long id, @PathVariable Long respond) throws IllegalAccessException {
		var ongoingExam = ongoingExamService.findById(id);
		var responseOption = ongoingExamService.findResponseOptionById(respond);

		ongoingExamService.addGivenResponseById(ongoingExam, responseOption);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * This endpoint completes the requested ongoingExam
	 *
	 * @param  id Id of the ongoingExam that should be completed
	 * @return    ResponseEntity with the outcome of the process
	 */
	@ApiOperation(
			value = "This endpoint completes the requested ongoingExam",
			response = OngoingExam.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested ongoingExam",
					required = true
			) }
	)
	@PutMapping("/complete/{id}")
	public ResponseEntity<OngoingExam> complete(@PathVariable Long id){

		var ongoingExam = ongoingExamService.findById(id);

 		ongoingExamService.completeExam(ongoingExam);
		return new ResponseEntity<>(ongoingExam, HttpStatus.OK);
	}
	
	/**
	 * This endpoint returns the average score for each Exam
	 *
	 * @return		List with average Scores for each Exam
	 */
	@ApiOperation(
			value = "This endpoint returns the average score for each Exam",
			response = Double.class
	)
	@GetMapping({"/averageScores"})
	public ResponseEntity<List<Object>> getAverageScore() {
		//Get average score for each exam 
		List<Object> scores = ongoingExamService.getAverageScore();
			return new ResponseEntity<>(scores, HttpStatus.OK);
	}

}
