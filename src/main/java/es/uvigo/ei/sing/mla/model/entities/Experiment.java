package es.uvigo.ei.sing.mla.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.uvigo.ei.sing.mla.util.CellNameType;

@Entity
public class Experiment {
	@Id
	@GeneratedValue
	private long experimentId;

	@Column(length = 32, nullable = false)
	private String name;

	@Column(length = 500)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private int numRows;
	
	private int numCols;
	
	private CellNameType rowNameType;
	
	private CellNameType colNameType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "experiment")
	private List<Condition> conditions;

	public Experiment() {
	}

	public long getExperimentId() {
		return experimentId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public CellNameType getRowNameType() {
		return rowNameType;
	}

	public CellNameType getColNameType() {
		return colNameType;
	}

	public User getUser() {
		return user;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setExperimentId(long experimentId) {
		this.experimentId = experimentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public void setRowNameType(CellNameType rowNameType) {
		this.rowNameType = rowNameType;
	}

	public void setColNameType(CellNameType colNameType) {
		this.colNameType = colNameType;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
