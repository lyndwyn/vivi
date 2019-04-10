package ch.zhaw.vivi.webContext.domain.user;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import ch.zhaw.vivi.webContext.domain.role.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This class is the Entity User. A User can hold multiple roles with its own
 * authorities.
 * 
 * @author Yves Kaufmann
 */
@ApiModel(value = "User", description = "User Entity")
@Entity(name = "users")
public class User extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "username")
	private String username;
	
	@ApiModelProperty(required = true)
	@Column(name = "password")
	private String password;
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(required = true)
	@Column(name = "surname")
	private String surname;
	
	@ApiModelProperty(required = true)
	@Column(name = "account_expiration_date")
	@Type(type = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Zurich")
	private Date accountExpirationDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "credentials_expiration_date")
	@Type(type = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date credentialsExpirationDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "locked")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean locked;
	
	@ApiModelProperty(required = true)
	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	public User() {}

	/**
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 * @param roles
	 */
	public User(
			String username, String password, String name, String surname, Date accountExpirationDate,
			Date credentialsExpirationDate, Boolean locked, Boolean enabled, Set<Role> roles
	) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
		this.roles = roles;
	}

	/**
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 * @param roles
	 */
	public User(
			Long id, String username, String password, String name, String surname, Date accountExpirationDate,
			Date credentialsExpirationDate, Boolean locked, Boolean enabled, Set<Role> roles
	) {
		super(id);
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
		this.roles = roles;
	}

	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the name
	 */
	public String getFirstName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setFirstName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the surname
	 */
	public String getLastName() {
		return surname;
	}

	
	/**
	 * @param surname the surname to set
	 */
	public void setLastName(String surname) {
		this.surname = surname;
	}

	
	/**
	 * @return the accountExpirationDate
	 */
	public Date getAccountExpirationDate() {
		return accountExpirationDate;
	}

	
	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	
	/**
	 * @return the credentialsExpirationDate
	 */
	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	
	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	
	/**
	 * @return the locked
	 */
	public Boolean isLocked() {
		return locked;
	}

	
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	
	/**
	 * @return the enabled
	 */
	public Boolean isEnabled() {
		return enabled;
	}

	
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
