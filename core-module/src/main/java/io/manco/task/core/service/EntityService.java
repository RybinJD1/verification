package io.manco.task.core.service;

import io.manco.task.core.domain.MyEntity;

import java.util.Collection;

public interface EntityService {

	MyEntity save(MyEntity entity);
	
	MyEntity find(Long id);
	
	Collection<MyEntity> findAll();
	
}
