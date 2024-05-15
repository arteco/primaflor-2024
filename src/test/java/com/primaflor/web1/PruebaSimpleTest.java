package com.primaflor.web1;

import com.primaflor.web1.dto.Persona;
import com.primaflor.web1.error.PersonaError;
import com.primaflor.web1.service.PersonaService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PruebaSimpleTest {

	@Test
	public void verificarListaInicial() {
		// inicialización
		PersonaService personaService = new PersonaService();

		// ejecución de la lógica
		List<Persona> personas = personaService.getPersonas();

		// verificación
		Assert.isTrue(personas.size() == 2, "Número de personas incorrecto");
	}


	@Test
	public void verificarPersona1() {
		// inicialización
		PersonaService personaService = new PersonaService();

		// ejecución de la lógica
		Persona p = personaService.getPersona(1).orElseThrow();

		// verificación
		Assert.isTrue(p.getId().equals(1), "Se esperaba la persona con id 1");
	}

	@Test
	public void verificarLanzadoExcepcion() {
		// inicialización
		PersonaService personaService = new PersonaService();
		Persona p = new Persona(503, "José", 24);
		Exception e = null;

		// ejecutamos la lógica
		try {
			personaService.savePersona(p);
			// de los más específicos a los más genéricos
		} catch (PersonaError error) {
			e = error;
		}

		// verificación
		Assert.notNull(e, "Error al captura la excepción de persona ya borrada");
	}

}
