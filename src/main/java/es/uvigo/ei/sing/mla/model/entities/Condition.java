package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Condition {
	@Id
	@GeneratedValue
	private long conditionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experimentId")
	private Experiment experiment;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition")
	private List<Sample> samples;

	public long getConditionId() {
		return conditionId;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setConditionId(long conditionId) {
		this.conditionId = conditionId;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}
