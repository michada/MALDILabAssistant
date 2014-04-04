package es.uvigo.ei.sing.mla.view.models;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.User;
import es.uvigo.ei.sing.mla.services.ExperimentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class HomeViewModel {
	@WireVariable
	private ExperimentService experimentService;

	private User getUser() {
		final Session session = Sessions.getCurrent(false);
		
		if (session != null && session.hasAttribute("user")) {
			return (User) session.getAttribute("user");
		} else {
			Executions.sendRedirect("logout.zul");
			throw new IllegalStateException("Missing user in session");
		}
	}
	
	public List<Experiment> getExperiments() {
		return this.experimentService.listExperiments(getUser());
	}
	
	@Command
	public void edit(
		@BindingParam("experiment") Experiment experiment
	) {
		Executions.getCurrent().sendRedirect("experimentData.zul?id=" + experiment.getId());
	}
	
	@Command
	public void addExperiment() {
		final Session session = Sessions.getCurrent();

		if (session.hasAttribute("user")) {
			Executions.getCurrent().sendRedirect("experimentData.zul");
		}
	}

//	@Command
//	public void editExperiment() {
//		final Session session = Sessions.getCurrent();
//
//		if (session.hasAttribute("user")) {
//			Experiment experiment = experimentService
//					.getExperiment(experimentId);
//
//			session.setAttribute("experiment", experiment);
//
//			Executions.getCurrent().sendRedirect("experimentData.zul");
//		}
//	}
}
