package ch.zhaw.vivi.webContext.domain.exam;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity exam.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class ExamServiceImpl extends ExtendedServiceImpl<Exam> implements ExamService {

	public ExamServiceImpl(ExamRepository repository) {
		super(repository);
	}

}
