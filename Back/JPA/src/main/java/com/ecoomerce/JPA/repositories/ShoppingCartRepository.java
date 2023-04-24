package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.ShoppingCar;

import java.util.List;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCar, Long> {
	
	List<ShoppingCar> findByCliente(int cliente);
	
	void deleteByCliente(int client);

}
