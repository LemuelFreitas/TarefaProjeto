package com.TarefaProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TarefaProjeto.Entities.TarefasEntities;

public interface TarefaRepository extends JpaRepository<TarefasEntities, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}