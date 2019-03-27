package ch.zhaw.vivi.webContext.domain.answer;

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
@ApiModel(value = "Answer", description = "Answer Entity")
@Entity
@Table(name = "answer")
public class Answer extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "reply_text")
	private String reply;
	
	@ApiModelProperty(required = true)
	@Column(name = "response")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean response;
	
	public Answer() {}

	/**
	 * 
	 * @param reply
	 * @param response
	 */
	public Answer(String reply, Boolean response) {
		this.reply = reply;
		this.response = response;
	}
	
	/**
	 * 
	 * @param id
	 * @param reply
	 * @param response
	 */
	public Answer(Long id, String reply, Boolean response) {
		super(id);
		this.reply = reply;
		this.response = response;
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
	public Boolean getResponse() {
		return response;
	}

	
	/**
	 * @param response the response to set
	 */
	public void setResponse(Boolean response) {
		this.response = response;
	}
	
}
