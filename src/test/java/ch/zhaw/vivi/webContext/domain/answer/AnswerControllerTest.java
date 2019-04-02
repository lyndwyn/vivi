package ch.zhaw.vivi.webContext.domain.answer;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.zhaw.vivi.ViviApplicationTests;
import ch.zhaw.vivi.webContext.domain.answer.dto.AnswerDTO;

/**
 * JUnit-Tests the AnswerController.
 * 
 * @author Yves Kaufmann
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ViviApplicationTests.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
	
	@InjectMocks
	private AnswerController answerController;
	
	@Mock
	private AnswerService answerService;
	
	private MockMvc mockMvc;
	
	private Answer answerOne;
	private Answer answerTwo;
	private Answer answerToBeCreated;
	private Answer answerToBeDeleted;
	
	private List<Answer> answers;
	private List<AnswerDTO> answerDTOs;
	
	private AnswerDTO answerOneDTO;
	private AnswerDTO answerTwoDTO;
	private AnswerDTO answerToBeCreatedDTO;
	private AnswerDTO answerToBeDeletedDTO;
	
	@Before
	public void setup() throws Exception {
		// Initialize mockMvc
		mockMvc = MockMvcBuilders.standaloneSetup(answerController).build();
		
		// Setup answers
		answerOne = new Answer(1L, "Antwort A", false);
		answerTwo = new Answer(2L, "Antwort B", true);
		
		answers = new ArrayList<>();
		answers.add(answerOne);
		answers.add(answerTwo);
		
		answerToBeCreated = new Answer("Antwort B", true);
		answerToBeDeleted = new Answer(3L, "Antwort B", true);
		
		answerOneDTO = new AnswerDTO(1L, "Antwort A", false);
		answerTwoDTO = new AnswerDTO(2L, "Antwort B", true);
		
		answerDTOs = new ArrayList<>();
		answerDTOs.add(answerOneDTO);
		answerDTOs.add(answerTwoDTO);
		
		answerToBeCreatedDTO = new AnswerDTO("Antwort B", true);
		answerToBeDeletedDTO = new AnswerDTO(3L, "Antwort B", true);
	
	}
	
	/**
	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
	 * the searched answer, if it exsists.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsAnswer() throws JsonProcessingException, Exception {
		when(answerService.findById(answerOne.getId())).thenReturn(answerOne);
		
		Answer tescht = answerService.findById(1L);
		System.out.println(tescht.getReply());
		mockMvc.perform(MockMvcRequestBuilders.get("/answer/{id}", answerOne.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(new ObjectMapper().writeValueAsString(answerOne)));
	}
	
	/**
	 * This method tests if the getAll()-method works. 
	 * Returns all answers from the DB.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsAllAnswers() throws JsonProcessingException, Exception {
		when(answerService.findAll()).thenReturn(answers);
		mockMvc.perform(MockMvcRequestBuilders.get("/answer"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(new ObjectMapper().writeValueAsString(answerDTOs)));
	}
	
	/**
	 * This method tests the create(Answer answer)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenAnswer_returnsAnswer() throws JsonProcessingException, Exception {
		doNothing().when(answerService).save(answerToBeCreated);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/answer").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(answerToBeCreatedDTO)))
			.andExpect(status().isCreated())
			.andExpect(content().json(new ObjectMapper().writeValueAsString(answerToBeCreatedDTO)));
	}
	
	/**
	 * This method tests if the updateById(Long id)-method works.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void updateById() throws JsonProcessingException, Exception {
		doNothing().when(answerService).save(answerOne);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/answer/{id}", answerOneDTO.getId(), answerOneDTO).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(answerOneDTO)))
			.andExpect(status().isOk())
			.andExpect(content().json(new ObjectMapper().writeValueAsString(answerOneDTO)));
	}
	
	/**
	 * This method tests if the deleteById(Long id)-method works.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void deleteById_givenId() throws JsonProcessingException, Exception {
		doNothing().when(answerService).delete(answerToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/answer/{id}", answerToBeDeletedDTO.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
}