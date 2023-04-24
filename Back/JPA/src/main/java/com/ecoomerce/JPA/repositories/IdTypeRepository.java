package com.ecoomerce.JPA.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.IdType;
import org.springframework.data.repository.query.Param;

public interface IdTypeRepository extends CrudRepository<IdType, Long> {

	List<IdType> findAll();

}
