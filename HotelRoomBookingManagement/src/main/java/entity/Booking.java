package entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {

	private Long bookingid;
	private String guestName;
	private String roomType;
	private String city;
	private Double bookingAmount;
	private Integer numOfdays;
	
	@NonNull
	@CreationTimestamp
	private LocalDate bookingDate;
	private String bookingStaus;
}
