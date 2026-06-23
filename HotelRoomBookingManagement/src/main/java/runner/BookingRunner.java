package runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import entity.Booking;
import service.BookingServiceManagement;

public class BookingRunner implements CommandLineRunner {
	@Autowired
	private BookingServiceManagement bmg;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Booking> city= bmg.findByCityOrRoomType("Chennai", "Suite");
		city.forEach(System.out::println);
		
		List<Booking> amt=bmg.findByBookingAmountBetween(5000.0, 15000.0);
		amt.forEach(System.out::println);
		
		List<Booking> nod=bmg.findByNumberOfDaysBetween(2,5);
		nod.forEach(System.out::println);
		
		List<Booking> status=bmg.findByBookingStatusOrCity("confirmed","Hyderabad");
		status.forEach(System.out::println);
		
		List<Booking> date= bmg.findByBookingDateBetween(null, null);
		date.forEach(System.out::println);
		
		List<Booking> guest=bmg.findByGuestNameOrBookingStatus("Anitha","cancelled");
		guest.forEach(System.out::println);
		
		List<Booking> room=bmg.findByRoomTypeOrBookingStatus("deluxe", "pending");
		room.forEach(System.out::println);
		
		List<Booking> id=bmg.findByBookingIdBetween(101L, 110L);
		id.forEach(System.out::println);
	}

}
