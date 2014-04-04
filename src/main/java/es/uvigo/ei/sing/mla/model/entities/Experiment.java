package es.uvigo.ei.sing.mla.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private int id;

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
	
	@Enumerated(EnumType.STRING)
	private CellNameType rowNameType;
	
	@Enumerated(EnumType.STRING)
	private CellNameType colNameType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "experiment")
	private List<ConditionGroup> conditions;

	public Experiment() {
	}

	public int getId() {
		return id;
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

	public List<ConditionGroup> getConditions() {
		return conditions;
	}

	public void setExperimentId(int experimentId) {
		this.id = experimentId;
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

	public void setConditions(List<ConditionGroup> conditions) {
		this.conditions = conditions;
	}
}
