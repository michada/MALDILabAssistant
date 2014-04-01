package es.uvigo.ei.sing.mla.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Condition {
	@Id
	@GeneratedValue
	private long id;

	@OneToMany
	private List<Sample> samples;
}
