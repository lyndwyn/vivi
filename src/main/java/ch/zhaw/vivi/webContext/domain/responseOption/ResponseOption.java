package ch.zhaw.vivi.webContext.domain.responseOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Answer.
 * 
 * @author Yves Kaufmann
 *
 */
@ApiModel(value = "ResponseOption", description = "ResponseOption Entity")
@Entity
public class ResponseOption extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "reply_text")
	private String reply;
	
	@ApiModelProperty(required = true)
	@Column(name = "correct")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean correct;
	
	public ResponseOption() {}

	public ResponseOption(Long id) {
		super(id);
	}

	/**
	 *
	 * @param reply
	 * @param correct
	 */
	public ResponseOption(String reply, Boolean correct) {
		this.reply = reply;
		this.correct = correct;
	}

	/**
	 *
	 * @param id
	 * @param reply
	 * @param correct
	 */
	public ResponseOption(Long id, String reply, Boolean correct) {
		super(id);
		this.reply = reply;
		this.correct = correct;
	}

	
	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}

	
	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	
	/**
	 * @return the response
	 */
	public Boolean getCorrect() {
		return correct;
	}

	
	/**
	 * @param response the response to set
	 */
	public void setCorrect(Boolean response) {
		this.correct = response;
	}
	
}
