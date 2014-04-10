package es.uvigo.ei.sing.mla.daos;

import es.uvigo.ei.sing.mla.model.entities.User;

public interface UserDAO {
	public User add(User user);

	public User get(String login);
	
	public User reload(User user);
}
