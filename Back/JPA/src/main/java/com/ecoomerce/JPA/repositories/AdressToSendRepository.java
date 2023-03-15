package com.ecoomerce.JPA.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.AdressToSend;

public interface AdressToSendRepository extends CrudRepository<AdressToSend, Long> {
	
	Optional<AdressToSend> findById(String id);
	
	AdressToSend findByCliente(int client);

}
