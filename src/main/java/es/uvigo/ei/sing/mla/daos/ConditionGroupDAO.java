package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import es.uvigo.ei.sing.mla.model.entities.ConditionGroup;
import es.uvigo.ei.sing.mla.model.entities.Experiment;

public interface ConditionGroupDAO {
	public ConditionGroup add(ConditionGroup condition);

	public ConditionGroup get(Integer id);

	public ConditionGroup update(ConditionGroup condition);

	public void delete(ConditionGroup condition);

	public List<ConditionGroup> list(Experiment experiment);
}
