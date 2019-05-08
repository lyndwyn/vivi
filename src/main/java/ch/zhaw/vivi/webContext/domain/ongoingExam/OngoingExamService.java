package ch.zhaw.vivi.webContext.domain.ongoingExam;

import ch.zhaw.vivi.config.generic.ExtendedService;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;
import ch.zhaw.vivi.webContext.domain.user.User;
import java.util.List;

/**
 * This interface holds all data access related methods targeted towards the
 * entity ongoingExam.
 *
 * @author Yves Kaufmann
 */
public interface OngoingExamService extends ExtendedService<OngoingExam> {

    public ResponseOption findResponseOptionById(Long id);

    public void addGivenResponseById(OngoingExam ongoingExam, ResponseOption responseOption) throws IllegalAccessException;

    public void completeExam(OngoingExam ongoingExam);
    
    public List<Object> getAverageScore();
}
