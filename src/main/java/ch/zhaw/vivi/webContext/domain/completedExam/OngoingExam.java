package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import ch.zhaw.vivi.webContext.domain.exam.Exam;
import ch.zhaw.vivi.webContext.domain.givenResponse.GivenResponse;
import ch.zhaw.vivi.webContext.domain.user.User;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is the Entity OngoingExam.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "OngoingExam", description = "OngoingExam Entity")
@Entity
public class OngoingExam extends ExtendedEntity {

	@Column
	private int score;

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
	private Set<GivenResponse> givenResponses = new HashSet<>();

	@Column
	private LocalTime startTime;

	@Column
	private LocalTime endTime;

	@Column
	private Boolean completed;



	public OngoingExam() {
	}

	public OngoingExam(Long id) {
		super(id);
	}

	public OngoingExam(Exam exam, User user) {
		this.exam = exam;
		this.user = user;
	}

	public OngoingExam(Long id, int score, Boolean passed, Exam exam, Certificate certificate, User user, Set<GivenResponse> givenResponses, LocalTime startTime, LocalTime endTime, Boolean completed) {
		super(id);
		this.score = score;
		this.passed = passed;
		this.exam = exam;
		this.certificate = certificate;
		this.user = user;
		this.givenResponses = givenResponses;
		this.startTime = startTime;
		this.endTime = endTime;
		this.completed = completed;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public Boolean isPassed() {
		return getScore() >= exam.getMinimumScore() ? true : false;
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

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Boolean isCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
