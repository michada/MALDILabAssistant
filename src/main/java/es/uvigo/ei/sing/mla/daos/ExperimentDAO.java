package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.User;

public interface ExperimentDAO {
	public Experiment add(Experiment experiment);

	public Experiment get(Integer experimentId);

	public Experiment update(Experiment experiment);

	public void delete(Experiment experiment);

	public List<Experiment> list(User user);

	public Experiment reload(Experiment experiment);
}
