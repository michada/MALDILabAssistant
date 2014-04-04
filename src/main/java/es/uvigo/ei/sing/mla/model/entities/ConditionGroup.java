package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ConditionGroup {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Experiment experiment;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition")
	private List<Sample> samples;

	public int getId() {
		return id;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}
