package es.uvigo.ei.sing.mla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import es.uvigo.ei.sing.mla.daos.ExperimentDAO;
import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.User;

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
	public Experiment editExperiment(Experiment experiment) {
		return dao.editExperiment(experiment);
	}

	@Override
	public Experiment getExperiment(int experimentId) {
		return dao.getExperiment(experimentId);
	}
	
	@Override
	public void deleteExperiment(Experiment experiment) {
		dao.deleteExperiment(experiment);
	}

	@Override
	public List<Experiment> listExperiments(User user) {
		return dao.listExperiments(user);
	}
}
