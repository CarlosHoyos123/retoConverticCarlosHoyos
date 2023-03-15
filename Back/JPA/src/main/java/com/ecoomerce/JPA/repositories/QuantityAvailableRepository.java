package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.QuantityAvailable;

public interface QuantityAvailableRepository extends CrudRepository<QuantityAvailable, Long> {
	
	Iterable<QuantityAvailable> findByProducto(int producto);
	QuantityAvailable findByProductoAndColorAndTalla(int producto, int color, int talla);

}
