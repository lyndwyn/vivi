package ch.zhaw.vivi.webContext.domain.responseOption.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;

/**
 * DTO-class for the entity responseOption.
 * 
 * @author Yves Kaufmann
 *
 */
public class ResponseOptionDTO extends ExtendedDTO {
	
	private String reply;
	 
	private Boolean correct;
	
	/**
	 * 
	 */
	public ResponseOptionDTO() {
		super();
	}
	
	/**
	 * @param id
	 */
	public ResponseOptionDTO(Long id) {
		super(id);
	}
	
	/**
	 * 
	 * @param reply
	 * @param response
	 */
	public ResponseOptionDTO(String reply, Boolean correct) {
		super();
		this.reply = reply;
		this.correct = correct;
	}
	
	/**
	 * 
	 * @param id
	 * @param reply
	 * @param response
	 */
	public ResponseOptionDTO(Long id, String reply, Boolean correct) {
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
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	
}
