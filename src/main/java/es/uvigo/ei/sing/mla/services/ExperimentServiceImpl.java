package es.uvigo.ei.sing.mla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import es.uvigo.ei.sing.mla.daos.ExperimentDAO;
import es.uvigo.ei.sing.mla.model.entities.Experiment;

@Service("experimentService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExperimentServiceImpl implements ExperimentService {
	@Autowired
	ExperimentDAO dao;

	@Override
	public Experiment addExperiment(Experiment experiment) {
		return dao.addExperiment(experiment);
	}

	@Override
	public Experiment getExperiment(long experimentId) {
		return dao.getExperiment(experimentId);
	}
}
