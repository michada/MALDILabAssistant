package es.uvigo.ei.sing.mla.services;

import es.uvigo.ei.sing.mla.daos.UserDAO;
import es.uvigo.ei.sing.mla.model.entities.User;

public class UserServiceImpl implements UserService {

	UserDAO dao;

	@Override
	public User addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public User getUser(String login) {
		return dao.getUser(login);
	}

}
