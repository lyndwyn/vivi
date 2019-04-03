package ch.zhaw.vivi.webContext.domain.user.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.role.Role;
import ch.zhaw.vivi.webContext.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * DTO-class for the entity user.
 * 
 * @author Yves Kaufmann
 *
 */
public class UserDTO extends ExtendedDTO {

	private String username;

	private String password;

	private String name;

	private String surname;

	public UserDTO() {}

	/**
	 *
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 */
	public UserDTO(String username, String password, String name, String surname) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}

	/**
	 *
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 */
	public UserDTO(Long id, String username, String password, String name, String surname) {
		super(id);
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
