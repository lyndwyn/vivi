package ch.zhaw.vivi.webContext.domain.question;

import java.util.Arrays;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ch.zhaw.vivi.config.generic.ExtendedServiceImplTest;
import ch.zhaw.vivi.webContext.domain.answer.Answer;
import java.util.HashSet;
import java.util.Set;

/**
 * JUnit-Tests the service and serviceImpl.
 * 
 * @author Yves Kaufmann
 *
 */
public class QuestionServiceImplTest extends ExtendedServiceImplTest<QuestionServiceImpl, Question, QuestionRepository> {
	@InjectMocks
	private QuestionServiceImpl questionServiceImpl;
	
	@Mock
	private QuestionRepository questionRepository;
	
	private Question questionOne;
	private Question questionTwo;
	
	@Before
	public void setup() {
		Answer answerOne = new Answer(1L, "Antwort A", false);
		Answer answerTwo = new Answer(2L, "Antwort B", true);
		Set<Answer> answers = new HashSet<>(Arrays.asList(answerOne, answerTwo));
		
		questionOne = new Question(1L, "Question One?", 5, "read carefully!", answers);
		questionTwo = new Question(2L, "Question Two?", 5, "last question =)", answers);
		
		super.setup(questionServiceImpl, questionRepository, questionOne, questionTwo);
	}
}
