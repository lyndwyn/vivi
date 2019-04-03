package ch.zhaw.vivi.webContext.domain.certificate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Certificate.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "Certificate", description = "Certificate Entity")
@Entity
@Table(name = "certificate")
public class Certificate extends ExtendedEntity { 
	
	@ApiModelProperty(required = true)
	@Column(name = "issueDate")
	@Type(type = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Zurich")
	private Date issueDate;
	
}
