package com.primaflor.web1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direccion")
public class DireccionEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private String calle;

	@ManyToOne
	private PersonaEntity persona; // persona_id fk

}
