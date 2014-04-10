package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import es.uvigo.ei.sing.mla.model.entities.ConditionGroup;
import es.uvigo.ei.sing.mla.model.entities.Sample;

public interface SampleDAO {
	public Sample add(Sample sample);

	public Sample get(Integer id);
	
	public Sample reload(Sample sample);

	public Sample update(Sample sample);

	public void delete(Sample sample);

	public List<Sample> list(ConditionGroup condition);
}
