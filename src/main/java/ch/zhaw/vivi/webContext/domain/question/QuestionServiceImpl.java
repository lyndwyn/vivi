package ch.zhaw.vivi.webContext.domain.question;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

@Service
public class QuestionServiceImpl extends ExtendedServiceImpl<Question> implements QuestionService {

	public QuestionServiceImpl(QuestionRepository repository) {
		super(repository);
	}
	
}
