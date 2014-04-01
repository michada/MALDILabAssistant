package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Sample {
	@Id
	@GeneratedValue
	private long id;
	
	private List<Replicate> replicates;
}
