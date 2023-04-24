package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.Client;
import org.springframework.stereotype.Service;

public interface ClientesRepository extends CrudRepository<Client, Long> {

	Client findByEmail(String user);

}
