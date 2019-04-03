package ch.zhaw.vivi.webContext.domain.answer.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;

/**
 * DTO-class for the entity answer.
 * 
 * @author Yves Kaufmann
 *
 */
public class AnswerDTO extends ExtendedDTO {
	
	private String reply;
	 
	private Boolean response;
	
	/**
	 * 
	 */
	public AnswerDTO() {
		super();
	}
	
	/**
	 * @param id
	 */
	public AnswerDTO(Long id) {
		super(id);
	}
	
	/**
	 * 
	 * @param reply
	 * @param response
	 */
	public AnswerDTO(String reply, Boolean response) {
		super();
		this.reply = reply;
		this.response = response;
	}
	
	/**
	 * 
	 * @param id
	 * @param reply
	 * @param response
	 */
	public AnswerDTO(Long id, String reply, Boolean response) {
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
