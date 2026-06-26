package com.nt.Entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Product")
public class Product {
	
	@Id
	private Integer productId;
	@NonNull
	@Column(length=20)
	private String productName;
	@NonNull
	@Column(length=20)
	private Double price;
	@NonNull
	@Column(length=20)
	private Integer quantity;
	@Version
	@NonNull
	private Integer version;
}
