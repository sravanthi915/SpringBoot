package com.nt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.Entity.Product;

public interface IProductService{

	public List<Product> saveAllProducts(List<Product> products);

	public void updateProduct(Integer productId);
	
	public List<Product> getProductById(Integer ProductId);
}
