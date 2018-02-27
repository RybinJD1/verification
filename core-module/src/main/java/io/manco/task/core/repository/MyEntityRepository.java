package io.manco.task.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.manco.task.core.domain.MyEntity;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

	
	
}
