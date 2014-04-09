package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.ei.sing.mla.model.entities.ConditionGroup;
import es.uvigo.ei.sing.mla.model.entities.Experiment;

@Repository
public class ConditionGroupDAOImpl implements ConditionGroupDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public ConditionGroup add(ConditionGroup condition) {
		em.persist(condition);

		return condition;
	}

	@Override
	@Transactional(readOnly = true)
	public ConditionGroup get(Integer id) {
		return em.find(ConditionGroup.class, id);
	}

	@Override
	@Transactional
	public ConditionGroup update(ConditionGroup condition) {
		em.merge(condition);

		return condition;
	}

	@Override
	@Transactional
	public void delete(ConditionGroup condition) {
		em.remove(condition);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConditionGroup> list(Experiment experiment) {
		return em
				.createQuery(
						"FROM ConditionGroup ex WHERE ex.experiment = :experiment",
						ConditionGroup.class)
				.setParameter("experiment", experiment).getResultList();
	}
}
