package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Booking;
import repository.BookingRepository;

@Service
public class BookingServiceManagement {
	@Autowired
	BookingRepository bookrep;
	public List<Booking> findByCityOrRoomType(String city, String roomType) {
		return bookrep.findByCityOrRoomType(roomType, roomType);
	}
	public List<Booking> findByBookingAmountBetween(Double minAmount, Double maxAmount) {
		return bookrep.findByBookingAmountBetween(minAmount, maxAmount);
	}
	public List<Booking> findByNumberOfDaysBetween(Integer minDays, Integer maxDays) {
		return bookrep.findByNumberOfDaysBetween(minDays, maxDays);
	}
	public List<Booking> findByBookingStatusOrCity(String status, String city) {
		return bookrep.findByBookingStatusOrCity(status, city);
	}
	public List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate) {
		return bookrep.findByBookingDateBetween(startDate, endDate);
	}
	public List<Booking> findByGuestNameOrBookingStatus(String guestName, String status) {
		return bookrep.findByGuestNameOrBookingStatus(guestName, status);
	}
	public List<Booking> findByRoomTypeOrBookingStatus(String roomType, String status) {
		return bookrep.findByRoomTypeOrBookingStatus(roomType, status);
	}
	public List<Booking> findByBookingIdBetween(Long startId, Long endId) {
		return bookrep.findByBookingIdBetween(startId, endId);
	}
	public String register(List<Booking>data) {
	bookrep.saveAll(data);
		return "Data is save";
		
	}
}
