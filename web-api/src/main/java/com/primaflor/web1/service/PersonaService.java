package com.primaflor.web1.service;


import com.primaflor.web1.model.PersonaEntity;
import com.primaflor.web1.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class PersonaService {

	// Acceder diractamente a las funcionalidade de JPA
	private final EntityManager entityManager;

	private final PersonaRepository personaRepository;
	private final JdbcTemplate jdbcTemplate;
	private final TransactionTemplate transactionTemplate;
	private final ApplicationContext context;


	public PersonaService(EntityManager entityManager, PersonaRepository personaRepository, JdbcTemplate jdbcTemplate,
						  TransactionTemplate transactionTemplate, ApplicationContext context) {

		this.entityManager = entityManager;
		this.personaRepository = personaRepository;
		this.jdbcTemplate = jdbcTemplate;
		this.transactionTemplate = transactionTemplate;
		this.context = context;

		transactionTemplate.executeWithoutResult(txt -> {
			// lógica que iría en una transacción
			// find, delete, insert


			// antes de la última llave, se haría commit si no hay error,
			// rollback en caso contrario
		});

	}

	@PostConstruct
	@Transactional
	public void init() {

		this.savePersona(new PersonaEntity(null, "Ramón", 43));
		this.savePersona(new PersonaEntity(null, "Pepe", 47));

		System.out.println(Arrays.stream(context.getBeanDefinitionNames()).toList());
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
