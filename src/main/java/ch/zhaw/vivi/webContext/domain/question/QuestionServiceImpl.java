package ch.zhaw.vivi.webContext.domain.question;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity question.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class QuestionServiceImpl extends ExtendedServiceImpl<Question> implements QuestionService {

	public QuestionServiceImpl(QuestionRepository repository) {
		super(repository);
	}
	
}
