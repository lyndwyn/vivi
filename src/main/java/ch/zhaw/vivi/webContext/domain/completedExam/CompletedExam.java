package ch.zhaw.vivi.webContext.domain.completedExam;

import javax.persistence.*;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import ch.zhaw.vivi.webContext.domain.exam.Exam;
import ch.zhaw.vivi.webContext.domain.givenResponse.GivenResponse;
import ch.zhaw.vivi.webContext.domain.user.User;
import io.swagger.annotations.ApiModel;

import java.util.Set;

/**
 * This class is the Entity CompletedExam.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "CompletedExam", description = "CompletedExam Entity")
@Entity
public class CompletedExam extends ExtendedEntity {

	@Column
	private Integer score;

	@Column
	private Boolean passed;

	@ManyToOne
	private Exam exam;

	@OneToOne
	private Certificate certificate;
	
	@ManyToOne
	private User user;

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
	)
	private Set<GivenResponse> givenResponses;

	public CompletedExam() {
	}

	public CompletedExam(Long id) {
		super(id);
	}

	public CompletedExam(Integer score, Boolean passed, Exam exam, Certificate certificate, User user, Set<GivenResponse> givenResponses) {
		this.score = score;
		this.passed = passed;
		this.exam = exam;
		this.certificate = certificate;
		this.user = user;
		this.givenResponses = givenResponses;
	}

	public CompletedExam(Long id, Integer score, Boolean passed, Exam exam, Certificate certificate, User user, Set<GivenResponse> givenResponses) {
		super(id);
		this.score = score;
		this.passed = passed;
		this.exam = exam;
		this.certificate = certificate;
		this.user = user;
		this.givenResponses = givenResponses;
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

	public Set<GivenResponse> getGivenResponses() {
		return givenResponses;
	}

	public void setGivenResponses(Set<GivenResponse> givenResponses) {
		this.givenResponses = givenResponses;
	}
}
