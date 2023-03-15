package com.ecoomerce.JPA.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.IdType;

public interface IdTypeRepository extends CrudRepository<IdType, Long> {
	
	List<IdType> findAll();

}
