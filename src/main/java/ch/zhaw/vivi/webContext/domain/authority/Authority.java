package ch.zhaw.vivi.webContext.domain.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the entity authority.
 * 
 * @author Yves Kaufmann
 *
 */
@ApiModel(value = "Authority", description = "Authority Entity")
@Entity
public class Authority extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	public Authority() {}
	
	/**
	 * 
	 * @param name
	 */
	public Authority(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Authority(Long id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
