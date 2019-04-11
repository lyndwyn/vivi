package ch.zhaw.vivi.webContext.domain.question.dto;

import java.util.Set;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;

/**
 * DTO-class for the entity answer.
 * 
 * @author Yves Kaufmann
 *
 */
public class QuestionDTO extends ExtendedDTO {
	
	private String question_text;
	
	private int scores;
	
	private String notice;
	
	private Set<ResponseOption> responseOption;
	
	public QuestionDTO() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 */
	public QuestionDTO(Long id) {
		super(id);
	}

	/**
	 * 
	 * @param question_text
	 * @param scores
	 * @param notice
	 * @param answers
	 */
	public QuestionDTO(String question_text, int scores, String notice, Set<ResponseOption> responseOption) {
		super();
		this.question_text = question_text;
		this.scores = scores;
		this.notice = notice;
		this.responseOption = responseOption;
	}
	
	/**
	 * 
	 * @param id
	 * @param question_text
	 * @param scores
	 * @param notice
	 * @param responseOption
	 */
	public QuestionDTO(Long id, String question_text, int scores, String notice, Set<ResponseOption> responseOption) {
		super(id);
		this.question_text = question_text;
		this.scores = scores;
		this.notice = notice;
		this.responseOption = responseOption;
	}

	
	/**
	 * @return the question_text
	 */
	public String getQuestion_text() {
		return question_text;
	}

	
	/**
	 * @param question_text the question_text to set
	 */
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	
	/**
	 * @return the scores
	 */
	public int getScores() {
		return scores;
	}

	
	/**
	 * @param scores the scores to set
	 */
	public void setScores(int scores) {
		this.scores = scores;
	}

	
	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	
	/**
	 * @param notice the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	
	/**
	 * @return the responseOption
	 */
	public Set<ResponseOption> getResponseOption() {
		return responseOption;
	}

	
	/**
	 * @param responseOption the responseOption to set
	 */
	public void setResponseOption(Set<ResponseOption> responseOption) {
		this.responseOption = responseOption;
	}

	
}
