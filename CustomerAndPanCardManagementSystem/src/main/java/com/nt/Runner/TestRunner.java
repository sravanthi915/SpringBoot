package com.nt.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Customer;
import com.nt.Entity.PanCard;
import com.nt.Repository.ICustomerRepository;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private ICustomerRepository custRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//pancard details
		PanCard pan=new PanCard();
		pan.setPanId(101L);
		pan.setPanNumber("SPUF129OOO");
		pan.setIssueDate("11/11/2028");
		
		//customer details
		Customer customer= new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Swathi");
		customer.setEmail("thotlaswathi@gmail.com");
		customer.setCity("Hyderabad");
		
		//establish connection
		customer.setPancard(pan);
		pan.setCustomer(customer);
		
		//save customer details
		custRepo.save(customer);
		
		//fetch customer details
		List<Customer> cust=custRepo.findAll();
		
		//delete customer details
		custRepo.deleteById(101L);
		 System.out.println("\nCustomer Deleted");
		
		
	}

}
