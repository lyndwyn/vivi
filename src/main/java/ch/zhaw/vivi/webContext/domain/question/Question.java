package ch.zhaw.vivi.webContext.domain.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.exam.Exam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Question. A Question can hold multiple Answers.
 * 
 * @author Yves Kaufmann
 *
 */
@ApiModel(value = "Question", description = "Question Entity")
@Entity
@Table(name = "question")
public class Question extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "questionText")
	private String question_text;
	
	@ManyToOne
	@JoinColumn
	private Exam exam;
	
	public Question() {}

	/**
	 * 
	 * @param question_text
	 */
	public Question(String question_text) {
		super();
		this.question_text = question_text;
		this.exam = exam;
	}
	
	/**
	 * 
	 * @param question_text
	 * @param exam
	 */
	public Question(String question_text, Exam exam) {
		super();
		this.question_text = question_text;
		this.exam = exam;
	}
	
	/**
	 * 
	 * @param id
	 * @param question_text
	 * @param exam
	 */
	public Question(Long id, String question_text, Exam exam) {
		super(id);
		this.question_text = question_text;
		this.exam = exam;
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
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

	
	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
