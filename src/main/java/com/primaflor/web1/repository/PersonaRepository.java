package com.primaflor.web1.repository;

import com.primaflor.web1.model.PersonaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {


	public List<PersonaEntity> findByNombreLikeOrderByEdadAsc(String nombre);

	@Query(value = "from PersonaEntity where nombre like ?1 order by edad asc ")
	public List<PersonaEntity> findByNombreLikeOrderByEdadAscV2(String nombre);

	@Query(value = "select * from persona where nombre like ?1 order by edad asc ", nativeQuery = true)
	public List<PersonaEntity> findByNombreLikeOrderByEdadAscV3(String nombre);
}
