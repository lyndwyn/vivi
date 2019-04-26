package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedService;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;

import java.util.Set;

/**
 * This interface holds all data access related methods targeted towards the
 * entity completedExam.
 *
 * @author Yves Kaufmann
 */
public interface OngoingExamService extends ExtendedService<OngoingExam> {

    public ResponseOption findResponseOptionById(Long id);

    public void addGivenResponseById(OngoingExam ongoingExam, ResponseOption responseOption);

    public void completeExam(OngoingExam ongoingExam);
}
