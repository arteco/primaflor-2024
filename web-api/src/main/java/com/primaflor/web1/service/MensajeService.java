package com.primaflor.web1.service;

import com.primaflor.web1.model.MensajeEntity;
import com.primaflor.web1.repository.MensajeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeService {

	private final MensajeRepository mensajeRepository;

	public void guardarMensaje(String mensaje) {

		MensajeEntity mensajeEntity = new MensajeEntity();
		mensajeEntity.setMensaje(mensaje);
		mensajeRepository.save(mensajeEntity);
	}

	public List<MensajeEntity> leerMensajes() {

		return mensajeRepository.findAll(Sort.by(Order.desc("id")));
	}
}
