package es.uvigo.ei.sing.mla.view.models;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.services.ExperimentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ExperimentViewModel {
	@WireVariable
	private ExperimentService experimentService;

	private long experimentId;

	@Command
	public void addExperiment() {
		final Session session = Sessions.getCurrent();

		if (session.hasAttribute("user")) {
			Executions.getCurrent().sendRedirect("exmperimentData.zul");
		}
	}

	@Command
	public void editExperiment() {
		final Session session = Sessions.getCurrent();

		if (session.hasAttribute("user")) {
			Experiment experiment = experimentService
					.getExperiment(experimentId);

			session.setAttribute("experiment", experiment);

			Executions.getCurrent().sendRedirect("exmperimentData.zul");
		}
	}
}
