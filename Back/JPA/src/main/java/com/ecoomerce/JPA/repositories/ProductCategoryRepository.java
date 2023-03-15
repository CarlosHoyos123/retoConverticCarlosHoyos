package com.ecoomerce.JPA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecoomerce.JPA.entitys.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

}
