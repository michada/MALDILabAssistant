package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Condition {
	@Id
	@GeneratedValue
	private long id;
	
	private Experiment experiment;

	@OneToMany
	private List<Sample> samples;

	public Experiment getExperiment() {
		return experiment;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}
