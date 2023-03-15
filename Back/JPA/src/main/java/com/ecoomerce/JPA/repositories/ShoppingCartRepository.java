package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.ShoppingCar;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCar, Long> {
	
	Iterable<ShoppingCar> findByCliente(int cliente);
	
	void deleteByCliente(int client);

}
