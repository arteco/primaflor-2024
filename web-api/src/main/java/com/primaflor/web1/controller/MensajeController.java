package com.primaflor.web1.controller;

import com.primaflor.web1.model.MensajeEntity;
import com.primaflor.web1.service.MensajeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensajes")
@RequiredArgsConstructor
public class MensajeController {

	private final MensajeService mensajeService;

	@PostMapping("")
	public ResponseEntity<Void> enviarMensaje(@RequestParam("msj") String mensaje) {

		if (mensaje != null && !mensaje.isEmpty()) {
			mensajeService.guardarMensaje(mensaje);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("")
	public List<MensajeEntity> leerMensajes() {

		return mensajeService.leerMensajes();
	}

}
