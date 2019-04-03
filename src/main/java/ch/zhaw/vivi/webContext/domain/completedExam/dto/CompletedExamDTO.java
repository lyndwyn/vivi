package ch.zhaw.vivi.webContext.domain.completedExam.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.user.dto.UserDTO;

import java.sql.Date;

/**
 * DTO-class for the entity certificate.
 * 
 * @author Yves Kaufmann
 *
 */
public class CompletedExamDTO extends ExtendedDTO {

	private Date issueDate;

	private UserDTO user;



	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
