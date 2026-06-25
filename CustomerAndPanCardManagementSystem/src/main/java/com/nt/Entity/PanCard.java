package com.nt.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class PanCard {
	@Id
	private Long panId;
	
	@Column(length=50)
	private String panNumber;
	
	@Column(length=50)
	private String issueDate;
	
	@OneToOne(mappedBy = "pancard")
	private Customer customer;
}
