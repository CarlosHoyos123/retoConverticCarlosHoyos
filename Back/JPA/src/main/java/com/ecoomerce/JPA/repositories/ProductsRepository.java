package com.ecoomerce.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.ecoomerce.JPA.entitys.Product;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {

	List<Product> findByGenero(int i);
	List<Product> findFirst4ByOrderByBusquedasDesc();

}
