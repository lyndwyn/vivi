package ch.zhaw.vivi.webContext.domain.question;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

public class QuestionServiceImpl extends ExtendedServiceImpl<Question> implements QuestionService {

	public QuestionServiceImpl(QuestionRepository repository) {
		super(repository);
	}
	
}
