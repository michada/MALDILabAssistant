package es.uvigo.ei.sing.mla.services;

import es.uvigo.ei.sing.mla.model.entities.User;

public interface UserService {
	public User addUser(User user);

	public User getUser(String login);
}
