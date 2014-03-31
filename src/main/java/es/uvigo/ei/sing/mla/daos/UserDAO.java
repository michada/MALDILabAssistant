package es.uvigo.ei.sing.mla.daos;

import javax.persistence.EntityManager;

import es.uvigo.ei.sing.mla.model.entities.User;

public class UserDAO {

	private EntityManager em;

	public User addUser(User user) {
		em.persist(user);

		return user;
	}

	public User getUser(String login) {
		return em.find(User.class, login);
	}
}
