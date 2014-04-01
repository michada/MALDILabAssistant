package es.uvigo.ei.sing.mla.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private List<Condition> conditions;

	public Experiment() {
	}
}
