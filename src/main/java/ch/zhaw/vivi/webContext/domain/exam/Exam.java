package ch.zhaw.vivi.webContext.domain.exam;

import java.sql.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.question.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	@Column(name = "startDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "endDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "duration")
	private int duration;
	
	@ApiModelProperty(required = true)
	@Column(name = "minimumScore")
	private int minimumScore;
	
	@ApiModelProperty(required = true)
	@OneToMany(mappedBy = "Exam", cascade = CascadeType.PERSIST)
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
	
}
