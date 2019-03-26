package ch.zhaw.vivi.webContext.domain.exam;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

public class ExamServiceImpl extends ExtendedServiceImpl<Exam> implements ExamService {

	public ExamServiceImpl(ExamRepository repository) {
		super(repository);
	}
	
}
