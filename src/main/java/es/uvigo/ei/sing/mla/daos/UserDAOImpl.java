package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.ei.sing.mla.model.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public User addUser(User user) {
		em.persist(user);

		return user;
	}

	@Transactional(readOnly = true)
	public User getUser(String login) {
		return em.find(User.class, login);
	}
}
