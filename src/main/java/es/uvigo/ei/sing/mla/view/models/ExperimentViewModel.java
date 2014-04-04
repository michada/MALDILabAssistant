package es.uvigo.ei.sing.mla.view.models;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.services.ExperimentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ExperimentViewModel {
	@WireVariable
	private ExperimentService experimentService;
	
	private Experiment experiment;
	
	@Init
	public void init() {
		final String experimentId = Executions.getCurrent().getParameter("id");
		
		if (experimentId == null) {
			Executions.sendRedirect("home.zul");
		} else {
			final int id = Integer.parseInt(experimentId);
			
			this.experiment = experimentService.getExperiment(id);
		}
	}
	
	public Experiment getExperiment() {
		return experiment;
	}
}
