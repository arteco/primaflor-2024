package com.primaflor.web1.controller;

import com.primaflor.web1.dto.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiControlador {

	@GetMapping("/")
	public String index() {

		return "Hello World";
	}

	@GetMapping("/test")
	public String indexConParametro(@RequestParam("page") Integer pagina) {

		System.out.println("pagina: " + pagina);
		return "Hello World";
	}

	@GetMapping("/persona/{id}")
	public String indexConPathVariable(@PathVariable("id") Integer idPersona) {

		System.out.println("idPersona: " + idPersona);
		return "Me has pedido la info de la persona " + idPersona;
	}

	@GetMapping("/response/{id}")
	public ResponseEntity<String> indexConResponseEntity(@PathVariable("id") Integer idPersona) {

		if (idPersona.equals(4)) {
			return ResponseEntity
				.ok("Los datos de la persona son...");
		} else {
			return ResponseEntity
				.status(HttpStatus.FORBIDDEN)
				.body("No puedes consultar los datos de esta persona");
		}

	}

	@GetMapping("/json/{id}")
	public ResponseEntity<Persona> personaEjemplo(@PathVariable("id") Integer idPersona) {
		if (idPersona.equals(4)) {
			Persona p = new Persona(1,"Ramón",43);
			// Persona p = ... buscarlo en la base de datos..
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.notFound().build();
	}
}
