package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.PanCard;

public interface IPanCardRepository extends JpaRepository<PanCard, Long> {

}
