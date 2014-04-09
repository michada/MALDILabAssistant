package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.ei.sing.mla.model.entities.Replicate;
import es.uvigo.ei.sing.mla.model.entities.Sample;

@Repository
public class ReplicateDAOImpl implements ReplicateDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Replicate add(Replicate replicate) {
		em.persist(replicate);

		return replicate;
	}

	@Override
	@Transactional(readOnly = true)
	public Replicate get(Integer id) {
		return em.find(Replicate.class, id);
	}

	@Override
	@Transactional
	public Replicate update(Replicate replicate) {
		em.merge(replicate);

		return replicate;
	}

	@Override
	@Transactional
	public void delete(Replicate replicate) {
		em.remove(replicate);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Replicate> list(Sample sample) {
		return em
				.createQuery("FROM Replicate ex WHERE ex.sample = :sample",
						Replicate.class).setParameter("sample", sample)
				.getResultList();
	}
}
