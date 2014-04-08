package es.uvigo.ei.sing.mla.services;

import es.uvigo.ei.sing.mla.model.entities.User;

public interface UserService {
	public User add(User user);

	public User get(String login);
}
