package com.primaflor.web1.service;


import com.primaflor.web1.dto.Persona;
import com.primaflor.web1.error.PersonaError;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Getter
	private final List<Persona> personas = new ArrayList<>();
	private Integer id = 1;


	public PersonaService() {

		personas.add(new Persona(id++, "Ramón", 43));
		personas.add(new Persona(id++, "Pepe", 47));
	}


	public Optional<Persona> getPersona(Integer idPersona) {

		Persona result = null;
		for (Persona persona : personas) {
			if (persona.getId().equals(idPersona)) {
				result = persona;
				break;
			}
		}
		return Optional.ofNullable(result);
	}

	public Optional<Persona> deletePersona(Integer idPersona) {

		Optional<Persona> p = getPersona(idPersona);
		//p.ifPresent(persona -> personas.remove(persona));
		if (p.isPresent()) {
			personas.remove(p.get());
		}
		return p;
	}

	public Persona savePersona(Persona persona) throws PersonaError {
		Persona result = null;
		// si existe
		if (persona.getId() != null) {
			Optional<Persona> optional = getPersona(persona.getId());
			if (optional.isPresent()) {
				// actualizar la persona
				Persona dbPersona = optional.get();
				dbPersona.setNombre(persona.getNombre());
				dbPersona.setEdad(persona.getEdad());
				// el update no hace falta porque ya está en la lista de memoria.
				result = dbPersona;
			} else {
				throw new PersonaError("La persona ya no existe");
			}
		} else {
			persona.setId(id++);
			personas.add(persona);
			result = persona;
			// aquí haríamos el insert
		}
		return result;
	}
}
