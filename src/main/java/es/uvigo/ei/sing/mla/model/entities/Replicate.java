package es.uvigo.ei.sing.mla.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Replicate {
	@Id
	@GeneratedValue
	private long id;
	
	private int col;
	private int row;

	public Replicate() {
	}

	public Replicate(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
