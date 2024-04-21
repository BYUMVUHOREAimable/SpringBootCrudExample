package com.javatalent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatalent.model.Products;
import com.javatalent.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	ProductsRepository productsRepository;
	
	//getting all products by using method findAll() of CrudRepository
	
	public List<Products> getAllProducts(){
		List<Products> products = new ArrayList<Products>();
		productsRepository.findAll().forEach(products1 -> products.add(products1));
		return products;
		
	}
	
	//saving or updating a record by using save() method
	public void saveOrUpdate(Products products) {
		productsRepository.save(products);
		
	}
	
	//getting a specific product by using findById() method
	public Products getProductById(int id) {
		return productsRepository.findById(id).get();
	}
	
	//deleting the product
	public void delete(int id) {
		productsRepository.deleteById(id);
	}
}
