package ch.zhaw.vivi.webContext.domain.certificate.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.user.User;
import ch.zhaw.vivi.webContext.domain.user.dto.UserDTO;

import java.sql.Date;

/**
 * DTO-class for the entity certificate.
 * 
 * @author Yves Kaufmann
 *
 */
public class CertificateDTO extends ExtendedDTO {

	private Date issueDate;

	private UserDTO user;

	public CertificateDTO() {
	}

	public CertificateDTO(Long id) {
		super(id);
	}

	public CertificateDTO(Date issueDate, UserDTO user) {
		this.issueDate = issueDate;
		this.user = user;
	}

	public CertificateDTO(Long id, Date issueDate, UserDTO user) {
		super(id);
		this.issueDate = issueDate;
		this.user = user;
	}

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
