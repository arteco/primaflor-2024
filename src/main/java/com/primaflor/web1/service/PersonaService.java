package com.primaflor.web1.service;


import com.primaflor.web1.model.PersonaEntity;
import com.primaflor.web1.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService {

	// Acceder diractamente a las funcionalidade de JPA
	private final EntityManager entityManager;

	private final PersonaRepository personaRepository;


	public PersonaService(EntityManager entityManager, PersonaRepository personaRepository) {

		this.entityManager = entityManager;
		this.personaRepository = personaRepository;
	}

	@PostConstruct
	@Transactional
	public void init() {

		this.savePersona(new PersonaEntity(null, "Ramón", 43));
		this.savePersona(new PersonaEntity(null, "Pepe", 47));
	}

	@PreDestroy
	public void destroy() {

	}

	public List<PersonaEntity> getPersonas() {

		return this.personaRepository.findAll();
	}


	public Optional<PersonaEntity> getPersona(Integer idPersona) {
		return this.personaRepository.findById(idPersona);
	}

	public Optional<PersonaEntity> deletePersona(Integer idPersona) {

		Optional<PersonaEntity> personaOptional = getPersona(idPersona);
		personaOptional.ifPresent(persona -> this.personaRepository.delete(persona));
		return personaOptional;
	}

	public PersonaEntity savePersona(PersonaEntity persona) {

		return this.personaRepository.save(persona);
	}
}
