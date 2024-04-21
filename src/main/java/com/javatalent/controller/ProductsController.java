package com.javatalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatalent.model.Products;
import com.javatalent.service.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	ProductsService productsService;
	
	//create a get mapping to retrieve all the products details
	@GetMapping("/product")
	private List<Products> getAllProduct(){
		return productsService.getAllProducts();
	}
	
	//creating post mapping to save the product details
	@PostMapping("/products")
	private int saveProduct(@RequestBody Products products) {
		productsService.saveOrUpdate(products);
		return products.getProductid();
	}
	
	//fetch the product based on the product id 
	@GetMapping("/product/{productid}")
	private Products getProducts(@PathVariable("productid")int productid ) {
		return productsService.getProductById(productid);
	}
	
	//updating the product
	@PutMapping("/products")
	private Products updateProduct(@RequestBody Products products) {
		productsService.saveOrUpdate(products);
		return products;
	}
		
	//deleting the product based on the product id 
	@DeleteMapping("/product/{productid}")
	private void deleteProduct(@PathVariable("productid")int productid) {
		productsService.delete(productid);
	}
	

}
