package ch.zhaw.vivi.webContext.domain.certificate;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

import ch.zhaw.vivi.webContext.domain.user.User;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Certificate.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "Certificate", description = "Certificate Entity")
@Entity
public class Certificate extends ExtendedEntity { 
	
	@ApiModelProperty(required = true)
	@Column(name = "issueDate")
	private LocalDate issueDate;

	@ManyToOne
	private User user;

	public Certificate() {
	}

	public Certificate(Long id) {
		super(id);
	}

	public Certificate(User user) {
		this.user = user;
	}

	public Certificate(Long id, LocalDate issueDate, User user) {
		super(id);
		this.issueDate = issueDate;
		this.user = user;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
