package com.primaflor.web1.controller;

import com.primaflor.web1.dto.Persona;
import com.primaflor.web1.service.PersonaService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonaController {

	private final PersonaService personaService;

	//public PersonaController(PersonaService personaService) {
	//	this.personaService = personaService;
	//}

	@GetMapping("/personas")
	public List<Persona> getPersonas(){
		return personaService.getPersonas();
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable("id") Integer idPersona){
		Optional<Persona> personaOpt = personaService.getPersona(idPersona);
		if (personaOpt.isPresent()){
			return ResponseEntity.ok(personaOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable("id") Integer idPersona){
		Optional<Persona> personaOpt = personaService.deletePersona(idPersona);
		if (personaOpt.isPresent()){
			return ResponseEntity.ok(personaOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/personas")
	public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
		// TODO: implementar el próximo día
		return ResponseEntity.badRequest().build();
	}
}
