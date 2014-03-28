package es.uvigo.ei.sing.mla.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
	@Id
	@Column(length=32, nullable=false, unique=true)
	private String login;

	@Column(length=32, nullable=false)
	private String password;

	public User() {}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
}
