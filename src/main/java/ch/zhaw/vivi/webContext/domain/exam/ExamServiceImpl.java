package ch.zhaw.vivi.webContext.domain.exam;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

@Service
public class ExamServiceImpl extends ExtendedServiceImpl<Exam> implements ExamService {

	public ExamServiceImpl(ExamRepository repository) {
		super(repository);
	}
	
}
