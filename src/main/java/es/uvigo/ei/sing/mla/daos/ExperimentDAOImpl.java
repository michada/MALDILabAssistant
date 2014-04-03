package es.uvigo.ei.sing.mla.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.ei.sing.mla.model.entities.Experiment;

@Repository
public class ExperimentDAOImpl implements ExperimentDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Experiment addExperiment(Experiment experiment) {
		em.persist(experiment);

		return experiment;
	}

	@Transactional(readOnly = true)
	public Experiment getExperiment(long experimentId) {
		return em.find(Experiment.class, experimentId);
	}
}
