package es.uvigo.ei.sing.mla.daos;

import java.util.List;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.User;

public interface ExperimentDAO {
	public Experiment addExperiment(Experiment experiment);

	public Experiment getExperiment(int experimentId);

	public List<Experiment> listExperiments(User user);
}
