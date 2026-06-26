package com.nt.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Product;
import com.nt.Repository.IProductRepository;
import com.nt.Service.ProductService;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductService service;

	

	@Override
	public void run(String... args) throws Exception {
		Product p1=new Product();
		p1.setProductId(10);
		p1.setProductName("laptop");
		p1.setPrice(40000d);
		p1.setQuantity(1);
		
		Product p2=new Product();
		p2.setProductId(20);
		p2.setProductName("camera");
		p2.setPrice(50000d);
		p2.setQuantity(2);
		
		Product p3=new Product();
		p3.setProductId(40);
		p3.setProductName("phone");
		p3.setPrice(60000d);
		p3.setQuantity(3);
		
	List<Product> list = List.of(p1,p2,p3);
		List<Product> product = service.saveAllProducts(list);
		product.forEach(System.out::println);
		
		service.updateProduct(40);
		service.getProductById(10);
	}
		
}
