package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Football;

import jakarta.transaction.Transactional;

public interface FootballPlayerRepository extends JpaRepository<Football, Long> {
	@Query("SELECT f FROM Football f WHERE f.club = :club")
	public List<Football> findByClub(@Param("club") String club);

	@Query("SELECT f FROM Football f WHERE f.salary > :salary")
	public List<Football> findPlayersWithSalaryGreaterThan(@Param("salary") Double salary);

	@Query("SELECT f FROM Football f WHERE f.position = :position AND f.country = :country")
	public List<Football> findByPositionAndCountry(@Param("position") String position,
			@Param("country") String country);

	@Query("SELECT f FROM Football f WHERE f.playerName LIKE CONCAT(:prefix, '%')")
	public List<Football> findByNameStartsWith(@Param("prefix") String prefix);

	@Query("SELECT f FROM Football f WHERE f.jerseyNumber BETWEEN :start AND :end")
	public List<Football> findByJerseyNumberBetween(@Param("start") Integer start, @Param("end") Integer end);

	@Query("SELECT COUNT(f) FROM Football f WHERE f.country = :country")
	Long countPlayersByCountry(@Param("country") String country);

	@Query("SELECT f FROM Football f ORDER BY f.salary DESC")
	public List<Football> findHighestPaidPlayers();

	@Modifying
	@Transactional
	@Query("UPDATE Football f SET f.salary = :salary WHERE f.playerId = :id")
	int updateSalary(@Param("id") Long id, @Param("salary") Double salary);

	@Modifying
	@Transactional
	@Query("DELETE FROM Football f WHERE f.club = :club")
	int deleteByClub(@Param("club") String club);

	@Query("SELECT f.playerName, f.club FROM Football f")
	List<Object[]> getPlayerNameAndClub();

}
