package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
		Country findByNombrePais(String string);
}
