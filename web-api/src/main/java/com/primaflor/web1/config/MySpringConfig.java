package com.primaflor.web1.config;

import com.primaflor.web1.model.PersonaEntity;
import com.primaflor.web1.repository.PersonaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
// @EntityScan(value = "com.primaflor.web1.model")
@EntityScan(basePackageClasses = PersonaEntity.class)
@EnableJpaRepositories(basePackageClasses = PersonaRepository.class)
public class MySpringConfig {

}
