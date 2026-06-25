package com.nt.Entity;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customer")

public class Customer implements Serializable{
	
	@Id
	private Long customerId;
	@NonNull
	@Column(length=50)
	private String customerName;
	@NonNull
	@Column(length=50)
	private String email;
	@NonNull
	@Column(length=50)
	private String city;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="panId")
	private PanCard pancard;
}
