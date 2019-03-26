package ch.zhaw.vivi.webContext.domain.exam;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This class is the entity role.
 * 
 * @author Laura Steiner
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
	
	// TODO create one-to-many-relation

	public Exam() {
		
	}

	/**
	 * 
	 * @param name
	 * @param date
	 * @param description
	 */
	public Exam(String name, Date date, String description) {
		super();
		this.name = name;
		this.date = date;
		this.description = description;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 */
	public Exam(Long id, String name, Date date, String description) {
		super(id);
		this.name = name;
		this.date = date;
		this.description = description;
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
	
	
}
