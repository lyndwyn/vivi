package ch.zhaw.vivi.webContext.domain.answer;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

@Service
public class AnswerServiceImpl extends ExtendedServiceImpl<Answer> implements AnswerService {
	
	/**
	 * 
	 * @param repository
	 */
	public AnswerServiceImpl(AnswerRepository repository) {
		super(repository);
	}
	
}
