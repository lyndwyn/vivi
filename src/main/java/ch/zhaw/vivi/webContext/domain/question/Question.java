package ch.zhaw.vivi.webContext.domain.question;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.answer.Answer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Question. A Question can hold multiple Answers.
 * 
 * @author Laura Steiner
 *
 */
@ApiModel(value = "Question", description = "Question Entity")
@Entity
@Table(name = "question")
public class Question extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "question_text")
	private String question_text;
	
	@ApiModelProperty(required = true)
	@Column(name = "scores")
	private int scores;
	
	@ApiModelProperty(required = true)
	@Column(name = "notice")
	private String notice;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "question_answer", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "answer_id"))
	private Set<Answer> answers;
	
	public Question() {}

	/**
	 * 
	 * @param question_text
	 * @param scores
	 * @param notice
	 * @param answers
	 */
	public Question(String question_text, int scores, String notice, Set<Answer> answers) {
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
	public Question(Long id, String question_text, int scores, String notice, Set<Answer> answers) {
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
