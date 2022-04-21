package com.lopes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lopes.model.Cambio;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Long> {
	
	
	@Query(value = "from Cambio c where c.from = ?1 and c.to = ?2", nativeQuery = false)
	List<Cambio> findByFromTo(String from, String to);

}
