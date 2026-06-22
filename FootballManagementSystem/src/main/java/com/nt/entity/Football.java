package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
@Table(name="Football_player")
public class Football {
	@Id
	private Long playerId;
	private String playerName;
	private String country;
	private String club;
	private String position;
	private Double salary;
	private Integer jerseyNumber;
	@Version
	Integer version;
	@CreationTimestamp
	LocalDateTime createdAt;
	@UpdateTimestamp
	LocalDateTime updatedAt;
}
