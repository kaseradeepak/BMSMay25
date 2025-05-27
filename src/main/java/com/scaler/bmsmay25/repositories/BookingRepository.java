package com.scaler.bmsmay25.repositories;

import com.scaler.bmsmay25.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking save(Booking booking);
}
