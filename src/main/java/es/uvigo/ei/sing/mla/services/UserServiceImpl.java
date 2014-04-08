package es.uvigo.ei.sing.mla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import es.uvigo.ei.sing.mla.daos.UserDAO;
import es.uvigo.ei.sing.mla.model.entities.User;

@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;

	@Override
	public User add(User user) {
		return dao.add(user);
	}

	@Override
	public User get(String login) {
		return dao.get(login);
	}
}
