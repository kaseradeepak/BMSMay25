package com.scaler.bmsmay25.repositories;

import com.scaler.bmsmay25.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Optional<Show> findById(Long aLong);
}
