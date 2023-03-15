package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.InvoiceAdress;

public interface InvoiceAdressRepository extends CrudRepository<InvoiceAdress, Long> {

	InvoiceAdress findByCliente(int cliente);
}
