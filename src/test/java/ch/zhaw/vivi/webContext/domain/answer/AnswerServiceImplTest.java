package ch.zhaw.vivi.webContext.domain.answer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.zhaw.vivi.config.generic.ExtendedServiceImplTest;

/**
 * TODO guete kommentar? (finds chli nichtsussägend..) wenn neui version -> die andere service-tests-kommis ahpasse
 * JUnit-Tests the service and serviceImpl.
 * 
 * @author Yves Kaufmann
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceImplTest extends ExtendedServiceImplTest<AnswerServiceImpl, Answer, AnswerRepository> {

	@InjectMocks
	private AnswerServiceImpl answerServiceImpl;
	
	@Mock
	private AnswerRepository answerRepository;
	
	private Answer answerOne;
	private Answer answerTwo;
	
	@Before
	public void setup() {
		answerOne = new Answer(1L, "Antwort A", false);
		answerTwo = new Answer(2L, "Antwort B", true);
		
		super.setup(answerServiceImpl, answerRepository, answerOne, answerTwo);
	}
}
