package com.primaflor.web1.service;


import com.primaflor.web1.dto.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Getter
	private final List<Persona> personas = new ArrayList<>();


	public PersonaService() {
		personas.add(new Persona(1,"Ramón",43));
		personas.add(new Persona(2,"Pepe",47));
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
}
