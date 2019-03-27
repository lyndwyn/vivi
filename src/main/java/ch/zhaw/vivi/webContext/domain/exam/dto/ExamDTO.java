package ch.zhaw.vivi.webContext.domain.exam.dto;

import java.sql.Date;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.question.Question;

/**
 * DTO-class for the entity exam.
 * 
 * @author Yves Kaufmann
 *
 */
public class ExamDTO extends ExtendedDTO {
	
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	
	private String description;
	
	private Set<Question> questions;
	
	public ExamDTO() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 */
	public ExamDTO(Long id) {
		super(id);
	}
	
	/**
	 * 
	 * @param name
	 * @param date
	 * @param description
	 * @param questions
	 */
	public ExamDTO(String name, Date date, String description, Set<Question> questions) {
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
	 * @param questions
	 */
	public ExamDTO(Long id, String name, Date date, String description, Set<Question> questions) {
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
