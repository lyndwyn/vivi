package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity completedExam.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class CompletedExamServiceImpl extends ExtendedServiceImpl<CompletedExam> implements CompletedExamService {

	public CompletedExamServiceImpl(CompletedExamRepository repository) {
		super(repository);
	}
	
}
