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
public class Sample {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conditionId")
	private ConditionGroup condition;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sample")
	private List<Replicate> replicates;

	public int getId() {
		return id;
	}

	public ConditionGroup getCondition() {
		return condition;
	}

	public List<Replicate> getReplicates() {
		return replicates;
	}

	public void setId(int sampleId) {
		this.id = sampleId;
	}

	public void setCondition(ConditionGroup condition) {
		this.condition = condition;
	}

	public void setReplicates(List<Replicate> replicates) {
		this.replicates = replicates;
	}
}
