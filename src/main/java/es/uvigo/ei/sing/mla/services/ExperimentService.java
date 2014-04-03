package es.uvigo.ei.sing.mla.services;

import es.uvigo.ei.sing.mla.model.entities.Experiment;

public interface ExperimentService {
	public Experiment addExperiment(Experiment experiment);

	public Experiment getExperiment(long experimentId);
}
