package com.scaler.bmsmay25.repositories;

import com.scaler.bmsmay25.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
