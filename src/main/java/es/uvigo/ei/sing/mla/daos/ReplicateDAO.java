package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import es.uvigo.ei.sing.mla.model.entities.Replicate;
import es.uvigo.ei.sing.mla.model.entities.Sample;

public interface ReplicateDAO {
	public Replicate add(Replicate replicate);

	public Replicate get(Integer id);
	
	public Replicate reload(Replicate replicate);

	public Replicate update(Replicate replicate);

	public void delete(Replicate replicate);

	public List<Replicate> list(Sample sample);
}
