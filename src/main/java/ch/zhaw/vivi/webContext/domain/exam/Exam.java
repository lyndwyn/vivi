package ch.zhaw.vivi.webContext.domain.exam;

import java.sql.Date;
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
import ch.zhaw.vivi.webContext.domain.question.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This class is the Entity Exam. A Exam can hold multiple questions with its own
 * answers.
 * 
 * @author Yves Kaufmann
 */

@ApiModel(value = "Exam", description = "Exam Entity")
@Entity
@Table(name = "exam")
public class Exam extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(required = true)
	@Column(name = "date")
	private Date date;
	
	@ApiModelProperty(required = true)
	@Column(name = "description")
	private String description;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "exam_question", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private Set<Question> questions;

	public Exam() {}

	/**
	 * 
	 * @param name
	 * @param date
	 * @param description
	 */
	public Exam(String name, Date date, String description, Set<Question> questions) {
		super();
		this.name = name;
		this.date = date;
		this.description = description;
		this.questions = questions;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 */
	public Exam(Long id, String name, Date date, String description, Set<Question> questions) {
		super(id);
		this.name = name;
		this.date = date;
		this.description = description;
		this.questions = questions;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
}
