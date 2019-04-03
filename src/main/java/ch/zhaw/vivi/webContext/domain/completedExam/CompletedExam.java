package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import ch.zhaw.vivi.webContext.domain.exam.Exam;
import ch.zhaw.vivi.webContext.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

/**
 * This class is the Entity CompletedExam.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "CompletedExam", description = "CompletedExam Entity")
@Entity
@Table(name = "completed_exam")
public class CompletedExam extends ExtendedEntity {

	@Column
	private Integer score;

	@Column
	private Boolean passed;

	@ManyToOne
	private Exam exam;

	@OneToOne
	private Certificate certificate;

	private User user;

	public CompletedExam() {
	}

	public CompletedExam(Long id) {
		super(id);
	}

	public CompletedExam(Integer score, Boolean passed, Exam exam, Certificate certificate, User user) {
		this.score = score;
		this.passed = passed;
		this.exam = exam;
		this.certificate = certificate;
		this.user = user;
	}

	public CompletedExam(Long id, Integer score, Boolean passed, Exam exam, Certificate certificate, User user) {
		super(id);
		this.score = score;
		this.passed = passed;
		this.exam = exam;
		this.certificate = certificate;
		this.user = user;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getPassed() {
		return passed;
	}

	public void setPassed(Boolean passed) {
		this.passed = passed;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
