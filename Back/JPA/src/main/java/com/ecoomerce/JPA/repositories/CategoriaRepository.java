package com.ecoomerce.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.ecoomerce.JPA.entitys.Category;


public interface CategoriaRepository extends CrudRepository<Category, Long>, JpaRepository<Category, Long> {

}
	