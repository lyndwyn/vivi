package ch.zhaw.vivi.webContext.domain.question;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Question. A Question can hold multiple Answers.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(
	value = "Question",
	description = "Question Entity"
)
@Entity
public class Question extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "questionText")
	private String question_text;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
		)
	private Set<ResponseOption> responseOption;
	
	public Question() {}
	
	public Question(String question_text, Set<ResponseOption> responseOption) {
		super();
		this.question_text = question_text;
		this.responseOption = responseOption;
	}
	
	public Question(Long id, String question_text, Set<ResponseOption> responseOption) {
		super(id);
		this.question_text = question_text;
		this.responseOption = responseOption;
	}
	
	/**
	 * @return the question_text
	 */
	public String getQuestion_text() {
		return question_text;
	}
	
	/**
	 * @param question_text the question_text to set
	 */
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
	
	/**
	 * @return the responseOption
	 */
	public Set<ResponseOption> getResponseOption() {
		return responseOption;
	}
	
	/**
	 * @param responseOption the responseOption to set
	 */
	public void setResponseOption(Set<ResponseOption> responseOption) {
		this.responseOption = responseOption;
	}
	
}
