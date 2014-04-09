package es.uvigo.ei.sing.mla.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Replicate {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 32)
	private String name;

	private int col;
	private int row;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sampleId")
	private Sample sample;

	public Replicate() {
		this.name = "";
		this.sample = new Sample();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public Sample getSample() {
		return sample;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}
}
