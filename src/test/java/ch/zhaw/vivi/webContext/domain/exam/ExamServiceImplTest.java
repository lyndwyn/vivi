package ch.zhaw.vivi.webContext.domain.exam;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ch.zhaw.vivi.config.generic.ExtendedServiceImplTest;
import ch.zhaw.vivi.webContext.domain.answer.Answer;
import ch.zhaw.vivi.webContext.domain.question.Question;

/**
 * JUnit-Tests the service and serviceImpl.
 * 
 * @author Yves Kaufmann
 *
 */
public class ExamServiceImplTest extends ExtendedServiceImplTest<ExamServiceImpl, Exam, ExamRepository> {
	
	@InjectMocks
	private ExamServiceImpl examServiceImpl;
	
	@Mock
	private ExamRepository examRepository;
	
	private Exam examOne;
	private Exam examTwo;
	
	@Before
	public void setup() {
		Answer answerOne = new Answer(1L, "Antwort A", false);
		Answer answerTwo = new Answer(2L, "Antwort B", true);
		Set<Answer> answers = new HashSet<>(Arrays.asList(answerOne, answerTwo));
		
		Question questionOne = new Question(1L, "Question One?", 5, "read carefully!", answers);
		Question questionTwo = new Question(2L, "Question Two?", 5, "last question =)", answers);
		Set<Question> questions = new HashSet<>(Arrays.asList(questionOne, questionTwo));
		
		examOne = new Exam(1L, "Algebra - Exam", Date.valueOf("2020-01-01"), "Room: 321, Time: 10:00", questions);
		examTwo = new Exam(1L, "Algebra - Exam", Date.valueOf("2019-06-01"), "Room: 101, Time: 08:00", questions);
		
		super.setup(examServiceImpl,  examRepository,  examOne,  examTwo);
	}
	
}
