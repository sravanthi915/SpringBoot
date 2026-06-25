package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
