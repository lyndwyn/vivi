package ch.zhaw.vivi.webContext.domain.exam;

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

import ch.zhaw.vivi.webContext.domain.exam.dto.ExamDTO;
import ch.zhaw.vivi.webContext.domain.exam.dto.ExamMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity exam.
 * 
 * @author Yves Kaufmann
 *
 */
@RestController
@RequestMapping("/exams")
@Api(
		value = "ExamController",
		description = "This class holds all REST endpoints targeted towards the entity exam",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
public class ExamController {

	private ExamService examService;
	
	private ExamMapper examMapper;

	public ExamController() {}
	
	@Autowired
	public ExamController (ExamService examService, ExamMapper examMapper) {
		this.examService = examService;
		this.examMapper = examMapper;
	}
	
	/**
	 * This method returns the requested exam
	 * 
	 * @param id	Id of the requested exam
	 * @return		ResponseEntity with the exam that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested exam",
			response = Exam.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
						value = "Id of requested exam",
						required = true
				)}
	)
	@GetMapping("/{id}")
	public ResponseEntity<ExamDTO> getById(@PathVariable Long id) {
		Exam exam = examService.findById(id);
		return new ResponseEntity<>(examMapper.toDTO(exam), HttpStatus.OK);
	}
	
	/**
	 * This method returns all exams
	 * 
	 * @return		ResponseEntity with all exsisting exams
	 */
	@ApiOperation(
			value = "This endpoint returns all exams",
			response = Exam.class
	)
	@GetMapping({"", "/"})
	public ResponseEntity<List<ExamDTO>> getAll() {
		List<Exam> exams = examService.findAll();
		return new ResponseEntity<>(examMapper.toDTOs(exams), HttpStatus.OK);
	}
	
	/**
	 * This method creates an exam
	 * 
	 * @return		ResponseEntity with the exam that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an exam",
		response = Exam.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The exam to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<ExamDTO> create(@Valid @RequestBody ExamDTO examDTO) {
		
		// ensure examId is null
		examDTO.setId(null);
		
		// save exam
		Exam exam = examMapper.fromDTO(examDTO);
		examService.save(exam);
		return new ResponseEntity<>(examMapper.toDTO(exam), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the exam which will get updated
	 * @param exam	Updated exam
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested exam",
			response = Exam.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					value = "The current exam",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public ResponseEntity<ExamDTO> updateById(@PathVariable Long id, @Valid @RequestBody ExamDTO examDTO) {
		
		// ensure ID's are the same
		examDTO.setId(id);
		
		// update entity
		Exam exam = examMapper.fromDTO(examDTO);
		examService.update(exam);
			return new ResponseEntity<>(examMapper.toDTO(exam), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested exam
	 *
	 * @param  id Id of the exam that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested exam",
		response = Exam.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested exam",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		examService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
