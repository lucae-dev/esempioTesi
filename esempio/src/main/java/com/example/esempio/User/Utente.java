package com.example.esempio.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="Utenti")
public class Utente {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="ACCOUNTNONLOCKED")
	private boolean accountNonLocked;
	
	public Utente() {
		super();
	}
	
	public Utente(Utente u) {
		super();
		this.username=u.getUsername();
		this.password=u.getPassword();
	}

	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
