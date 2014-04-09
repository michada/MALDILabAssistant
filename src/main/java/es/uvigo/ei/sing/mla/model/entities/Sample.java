package es.uvigo.ei.sing.mla.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	private Integer id;

	@Column(length = 32)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditionId")
	private ConditionGroup condition;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sample")
	private List<Replicate> replicates;

	public Sample() {
		this.name = "";
		this.condition = new ConditionGroup();
		this.replicates = new ArrayList<Replicate>();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ConditionGroup getCondition() {
		return condition;
	}

	public List<Replicate> getReplicates() {
		return replicates;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCondition(ConditionGroup condition) {
		this.condition = condition;
	}

	public void setReplicates(List<Replicate> replicates) {
		this.replicates = replicates;
	}
}
