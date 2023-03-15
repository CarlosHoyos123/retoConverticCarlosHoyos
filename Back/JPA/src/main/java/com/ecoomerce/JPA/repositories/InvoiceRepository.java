package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, String>{
	
}
