package com.primaflor.web1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
public class MensajeEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	@NotNull
	@Length(min = 3, max = 255)
	String mensaje;
}
