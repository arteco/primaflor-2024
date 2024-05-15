package com.primaflor.web1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primaflor.web1.dto.Persona;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@Slf4j
@SpringBootTest
class PruebaApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void verifcarSerializacionPersona() throws JsonProcessingException {
		// Init
		Persona p1 = new Persona(1,"Pepe",50);
		Persona p2;

		// Lógica
		String json = objectMapper.writeValueAsString(p1);
		log.info(json);
		p2 = objectMapper.readValue(json, Persona.class);

		// Verificación
		 Assert.isTrue(p1.getId().equals(p2.getId()), "Ids dos same");
		 Assert.isTrue(p1.getNombre().equals(p2.getNombre()), "Nombres dos same");
		 Assert.isTrue(p1.getEdad().equals(p2.getEdad()), "Edad dos same");

		 Assert.isTrue(p1.equals(p2), "Las personas no son iguales");
	}

}
