package ch.zhaw.vivi.webContext.domain.exam;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.question.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Exam. A Exam can hold multiple questions with its
 * own
 * answers.
 * 
 * @author Yves Kaufmann
 */

@ApiModel(
	value = "Exam",
	description = "Exam Entity"
)
@Entity
public class Exam extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(required = true)
	@Column(name = "startDate")
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "yyyy-MM-dd"
	)
	private Date startDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "endDate")
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "yyyy-MM-dd"
	)
	private Date endDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "duration")
	private int duration;
	
	@ApiModelProperty(required = true)
	@Column(name = "minimumScore")
	private int minimumScore;
	
	@ApiModelProperty(required = true)
	@OneToMany(
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	private Set<Question> questions;
	
	public Exam() {}
	
	public Exam(String name, Date startDate, Date endDate, int duration, int minimumScore) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.minimumScore = minimumScore;
	}
	
	public Exam(String name, Date startDate, Date endDate, int duration, int minimumScore, Set<Question> questions) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.minimumScore = minimumScore;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the minimumScore
	 */
	public int getMinimumScore() {
		return minimumScore;
	}
	
	/**
	 * @param minimumScore the minimumScore to set
	 */
	public void setMinimumScore(int minimumScore) {
		this.minimumScore = minimumScore;
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
