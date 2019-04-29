package ch.zhaw.vivi.webContext.domain.completedExam.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.exam.dto.ExamDTO;
import ch.zhaw.vivi.webContext.domain.user.dto.UserDTO;

import java.sql.Date;
import java.time.LocalDate;

/**
 * DTO-class for the entity certificate.
 * 
 * @author Yves Kaufmann
 *
 */
public class OngoingExamDTO extends ExtendedDTO {

	private LocalDate issueDate;

	private ExamDTO exam;

	private UserDTO user;

	public OngoingExamDTO(){}

	public OngoingExamDTO(ExamDTO exam, UserDTO user){
		this.exam = exam;
		this.user = user;
	}

	public ExamDTO getExam() { return exam; }

	public void setExam(ExamDTO exam) { this.exam = exam; }

	public LocalDate getIssueDate() { return issueDate; }

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
