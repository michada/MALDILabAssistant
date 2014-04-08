package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.User;

@Repository
public class ExperimentDAOImpl implements ExperimentDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Experiment add(Experiment experiment) {
		em.persist(experiment);

		return experiment;
	}

	@Override
	@Transactional(readOnly = true)
	public Experiment get(Integer id) {
		return em.find(Experiment.class, id);
	}

	@Override
	@Transactional
	public Experiment update(Experiment experiment) {
		em.merge(experiment);

		return experiment;
	}

	@Override
	@Transactional
	public void delete(Experiment experiment) {
		em.remove(experiment);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Experiment> list(User user) {
		return em
				.createQuery("FROM Experiment ex WHERE ex.user = :user",
						Experiment.class).setParameter("user", user)
				.getResultList();
	}
}
