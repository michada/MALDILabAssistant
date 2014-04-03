package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sample {
	@Id
	@GeneratedValue
	private long id;
	
	private Condition condition;
	
	@OneToMany
	private List<Replicate> replicates;

	public Condition getCondition() {
		return condition;
	}

	public List<Replicate> getReplicates() {
		return replicates;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public void setReplicates(List<Replicate> replicates) {
		this.replicates = replicates;
	}
}
