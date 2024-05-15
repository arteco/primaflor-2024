package com.primaflor.web1.controller;

import com.primaflor.web1.dto.Persona;
import com.primaflor.web1.error.PersonaError;
import com.primaflor.web1.service.PersonaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonaController {

	// @Autowired (no recomendada)
	private final PersonaService personaService;

	//public PersonaController(PersonaService personaService) {
	//	this.personaService = personaService;
	//}

	@GetMapping("/personas")
	public List<Persona> getPersonas() {

		return personaService.getPersonas();
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable("id") Integer idPersona) {

		Optional<Persona> personaOpt = personaService.getPersona(idPersona);
		if (personaOpt.isPresent()) {
			return ResponseEntity.ok(personaOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable("id") Integer idPersona) {

		Optional<Persona> personaOpt = personaService.deletePersona(idPersona);
		if (personaOpt.isPresent()) {
			return ResponseEntity.ok(personaOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/personas")
	public ResponseEntity<Object> savePersona(@RequestBody @Valid Persona persona,
											  BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		try {
			Persona dbPersona = personaService.savePersona(persona);
			return ResponseEntity.ok(dbPersona);
		} catch (PersonaError e) {
			log.error(e.getMessage(), e);
			log.warn("Ha ocurrido un error al guardar el persona: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
