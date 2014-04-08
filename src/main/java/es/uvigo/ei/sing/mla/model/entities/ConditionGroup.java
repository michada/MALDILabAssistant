package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Column;
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
	private Integer id;

	@Column(length = 32)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	private Experiment experiment;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition")
	private List<Sample> samples;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}
