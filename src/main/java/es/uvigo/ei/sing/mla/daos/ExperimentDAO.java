package es.uvigo.ei.sing.mla.daos;

import es.uvigo.ei.sing.mla.model.entities.Experiment;

public interface ExperimentDAO {
	public Experiment addExperiment(Experiment experiment);

	public Experiment getExperiment(long experimentId);
}
