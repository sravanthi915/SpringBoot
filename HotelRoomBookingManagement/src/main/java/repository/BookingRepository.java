package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByCityOrRoomType(String city, String roomType);
	List<Booking> findByBookingAmountBetween(Double minAmount, Double maxAmount);
	List<Booking> findByNumberOfDaysBetween(Integer minDays, Integer maxDays);
	List<Booking> findByBookingStatusOrCity(String status, String city);
	List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
	List<Booking> findByGuestNameOrBookingStatus(String guestName, String status);
	List<Booking> findByRoomTypeOrBookingStatus(String roomType, String status);
	List<Booking> findByBookingIdBetween(Long startId, Long endId);
}
