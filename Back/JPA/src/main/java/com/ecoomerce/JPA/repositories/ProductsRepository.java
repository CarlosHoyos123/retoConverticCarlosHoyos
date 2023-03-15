package com.ecoomerce.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.ecoomerce.JPA.entitys.Product;

public interface ProductsRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {

	Iterable<Product> findByGenero(int i);
	Iterable<Product> findFirst4ByOrderByBusquedasDesc();

}
