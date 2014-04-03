package es.uvigo.ei.sing.mla.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.uvigo.ei.sing.mla.util.CellNameType;

@Entity
public class Experiment {
	@Id
	@GeneratedValue
	private long id;

	@Column(length = 32, nullable = false)
	private String name;

	@Column(length = 500)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private int plateHeight;
	
	private int plateWidth;
	
	private CellNameType horizontalName;
	
	private CellNameType verticalName;
	
	@OneToMany
	private List<Condition> conditions;

	public Experiment() {
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

	public int getPlateHeight() {
		return plateHeight;
	}

	public int getPlateWidth() {
		return plateWidth;
	}

	public CellNameType getHorizontalName() {
		return horizontalName;
	}

	public CellNameType getVerticalName() {
		return verticalName;
	}

	public List<Condition> getConditions() {
		return conditions;
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

	public void setPlateHeight(int plateHeight) {
		this.plateHeight = plateHeight;
	}

	public void setPlateWidth(int plateWidth) {
		this.plateWidth = plateWidth;
	}

	public void setHorizontalName(CellNameType horizontalName) {
		this.horizontalName = horizontalName;
	}

	public void setVerticalName(CellNameType verticalName) {
		this.verticalName = verticalName;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
