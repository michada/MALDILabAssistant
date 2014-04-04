package es.uvigo.ei.sing.mla.model.entities;

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
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sampleId")
	private Sample sample;
	
	private int col;
	private int row;

	public Replicate() {
	}

	public Replicate(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public int getId() {
		return id;
	}

	public Sample getSample() {
		return sample;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
