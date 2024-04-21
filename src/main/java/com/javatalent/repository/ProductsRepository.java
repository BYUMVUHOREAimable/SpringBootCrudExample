package com.javatalent.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatalent.model.Products;

public interface ProductsRepository extends CrudRepository<Products,Integer> {

}
