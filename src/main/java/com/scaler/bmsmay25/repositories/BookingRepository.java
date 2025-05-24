package com.scaler.bmsmay25.repositories;

import com.scaler.bmsmay25.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
