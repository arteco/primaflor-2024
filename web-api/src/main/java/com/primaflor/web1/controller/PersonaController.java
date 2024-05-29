package com.primaflor.web1.controller;

import com.primaflor.web1.dto.Persona;
import com.primaflor.web1.model.DireccionEntity;
import com.primaflor.web1.model.PersonaEntity;
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
import org.springframework.web.bind.annotation.RequestParam;
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

		return personaService.getPersonas().stream()
			.map(this::map)
			.toList();
	}

	private Persona map(PersonaEntity personaEntity) {

		return new Persona(personaEntity.getId(),
						   personaEntity.getNombre(),
						   personaEntity.getEdad());
	}

	private PersonaEntity map(Persona persona) {

		return new PersonaEntity(persona.getId(),
								 persona.getNombre(),
								 persona.getEdad());
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable("id") Integer idPersona) {

		Optional<PersonaEntity> personaOpt = personaService.getPersona(idPersona);
		if (personaOpt.isPresent()) {
			return ResponseEntity.ok(personaOpt
										 .map(this::map)
										 .get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable("id") Integer idPersona) {

		Optional<PersonaEntity> personaOpt = personaService.deletePersona(idPersona);
		if (personaOpt.isPresent()) {
			return ResponseEntity.ok(personaOpt
										 .map(this::map)
										 .get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/personas")
	public ResponseEntity<Object> savePersona(@RequestBody @Valid Persona persona,
											  BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}

		PersonaEntity p = map(persona);
		PersonaEntity dbPersona = personaService.savePersona(p);
		return ResponseEntity.ok(map(dbPersona));
	}

	@GetMapping("/personas/{id}/direcciones")
	public Persona getPersonaDirecciones(@PathVariable("id") Integer idPersona) {

		Optional<PersonaEntity> persona = personaService.getPersona(idPersona);
		persona.ifPresent(personaEntity -> {
			List<DireccionEntity> direcciones = personaEntity.getDirecciones();
			System.out.println(direcciones);
		});
		return null;
	}
}
