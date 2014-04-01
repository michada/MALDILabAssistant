package es.uvigo.ei.sing.mla.daos;

import es.uvigo.ei.sing.mla.model.entities.User;

public interface UserDAO {
	public User addUser(User user);
	
	public User getUser(String login);
}
