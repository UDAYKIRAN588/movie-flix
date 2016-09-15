package io.egen.server.entity;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({@NamedQuery(name = "User.email", query = "SELECT u  from User u where u.email=:pEmail"),
			   @NamedQuery(name = "User.authenticate", query = "SELECT u from User u where  u.passwd = :pPasswd and u.email =:pEmail and u.type =:pType")})
public class User {
	
	@Id
	private String user_id;
	@Column(unique=true)
	private String email;
	private String passwd;
	private String type;
	private String firstName;
	private String fastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFastName() {
		return fastName;
	}
	public void setFastName(String fastName) {
		this.fastName = fastName;
	}
	public User () {
		this.user_id = UUID.randomUUID().toString();
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPasswd() {    
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
