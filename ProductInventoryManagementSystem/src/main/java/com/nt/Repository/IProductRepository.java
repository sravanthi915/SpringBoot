package com.nt.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
