package es.uvigo.ei.sing.mla.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sample {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditionId")
	private ConditionGroup condition;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sample")
	private List<Replicate> replicates;

	public Sample() {
	}

	public Sample(ConditionGroup condition) {
		this.condition = condition;
		this.replicates = new ArrayList<Replicate>();
	}

	public int getId() {
		return id;
	}

	public ConditionGroup getCondition() {
		return condition;
	}

	public List<Replicate> getReplicates() {
		return replicates;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCondition(ConditionGroup condition) {
		this.condition = condition;
	}

	public void setReplicates(List<Replicate> replicates) {
		this.replicates = replicates;
	}
}
