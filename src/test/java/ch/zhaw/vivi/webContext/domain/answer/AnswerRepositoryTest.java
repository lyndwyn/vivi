package ch.zhaw.vivi.webContext.domain.answer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ch.zhaw.vivi.ViviApplicationTests;

/** TODO ganze Klasse löschen? (wird nicht gebraucht, kann jedoch als Vorlage dienen...
 * JUnit-Test repository
 * 
 * @author Yves Kaufmann
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = ViviApplicationTests.class)
@DataJpaTest
public class AnswerRepositoryTest {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Answer answerOne;
	private Answer answerTwo;
	
	@Before
	public void setup() {
		answerOne = new Answer("Antwort A", false);
		answerTwo = new Answer("Antwort B", true);
		entityManager.persist(answerOne);
		entityManager.persist(answerTwo);
	}
	
	// example for a repository-test
	@Test
	public void methodName_givenEntityNameExsists_returnEntity() {
		/**
		 * Entity entityFromDB = entityRepository.findByEntityAttribut(xy.getName());
		 * assertThat(entity).isEqualTo(entityFromDB);
		 */
	}
	
}
