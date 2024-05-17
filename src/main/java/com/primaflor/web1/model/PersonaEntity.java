package com.primaflor.web1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity { //persona

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	@Column(columnDefinition = "varchar(50)")
	private String nombre;

	@NotNull
	private Integer edad;

	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<DireccionEntity> direcciones;

	public PersonaEntity(Integer id, String nombre, Integer edad) {

		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
}
