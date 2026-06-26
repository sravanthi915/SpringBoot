package com.nt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Product;
import com.nt.Repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepo;
	
	public List<Product> saveAllProducts(List<Product> products) {
		return productRepo.saveAll(products);
	}


//	public Optional<Product> getProductById(Integer id) {
//		// TODO Auto-generated method stub
//		return productRepo.findById(1);
//	}


	public void updateProduct(Integer productId){
		Product product = productRepo.findById(productId).get();
		product.setProductName("SmartPhone");
		productRepo.save(product);	
	}


	@Override
	public List<Product> getProductById(Integer ProductId) {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}


}
	
	
	

