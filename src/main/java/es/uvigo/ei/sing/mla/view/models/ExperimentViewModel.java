package es.uvigo.ei.sing.mla.view.models;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import es.uvigo.ei.sing.mla.model.entities.ConditionGroup;
import es.uvigo.ei.sing.mla.model.entities.Experiment;
import es.uvigo.ei.sing.mla.model.entities.Replicate;
import es.uvigo.ei.sing.mla.model.entities.Sample;
import es.uvigo.ei.sing.mla.model.entities.User;
import es.uvigo.ei.sing.mla.services.ConditionGroupService;
import es.uvigo.ei.sing.mla.services.ExperimentService;
import es.uvigo.ei.sing.mla.services.ReplicateService;
import es.uvigo.ei.sing.mla.services.SampleService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ExperimentViewModel {
	@WireVariable
	private ExperimentService experimentService;

	@WireVariable
	private ConditionGroupService conditionGroupService;

	@WireVariable
	private SampleService sampleService;

	@WireVariable
	private ReplicateService replicateService;

	private Experiment experiment;
	private ConditionGroup condition;
	private Sample sample;
	private Replicate replicate;

	@Init
	public void init() {
		final Session session = Sessions.getCurrent();
		final String experimentId = Executions.getCurrent().getParameter("id");

		if (!session.hasAttribute("user")) {
			Executions.getCurrent().sendRedirect("index.zul");
		}

		if (experimentId != null) {
			final int id = Integer.parseInt(experimentId);

			this.experiment = experimentService.get(id);
		} else {
			this.experiment = new Experiment();
			this.experiment.setUser((User) Sessions.getCurrent().getAttribute(
					"user"));
		}
	}

	@Command
	public void save() {
		if (experiment.getId() == null) {
			this.experiment = this.experimentService.add(this.experiment);
		} else {
			experimentService.update(experiment);
		}
	}

	@Command
	public void reset() {
		// if (experiment.getId() == null) {
		// this.experiment = new Experiment();
		// } else {
		// this.experiment = experimentService.get(this.experiment.getId());
		// }
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public List<ConditionGroup> listConditions() {
		return this.conditionGroupService.list(this.condition.getExperiment());
	}

	public List<Sample> listSamples() {
		return this.sampleService.list(this.sample.getCondition());
	}

	public List<Replicate> listReplicates() {
		return this.replicateService.list(this.replicate.getSample());
	}

	public void addCondition() {
		ConditionGroup condition = new ConditionGroup();

		condition.setName("Condition"
				+ Integer.toString(this.listConditions().size() + 1));

		condition.setExperiment(this.experiment);
		condition.setSamples(new ArrayList<Sample>());

		this.conditionGroupService.add(condition);
	}
}
