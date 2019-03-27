package ch.zhaw.vivi.webContext.domain.question.dto;

import java.util.Set;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.answer.Answer;

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
	
	private Set<Answer> answers;
	
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
	public QuestionDTO(String question_text, int scores, String notice, Set<Answer> answers) {
		super();
		this.question_text = question_text;
		this.scores = scores;
		this.notice = notice;
		this.answers = answers;
	}
	
	/**
	 * 
	 * @param id
	 * @param question_text
	 * @param scores
	 * @param notice
	 * @param answers
	 */
	public QuestionDTO(Long id, String question_text, int scores, String notice, Set<Answer> answers) {
		super(id);
		this.question_text = question_text;
		this.scores = scores;
		this.notice = notice;
		this.answers = answers;
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
	 * @return the answers
	 */
	public Set<Answer> getAnswers() {
		return answers;
	}

	
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
}
