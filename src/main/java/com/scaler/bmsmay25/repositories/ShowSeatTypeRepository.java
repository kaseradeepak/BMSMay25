package com.scaler.bmsmay25.repositories;

import com.scaler.bmsmay25.models.Show;
import com.scaler.bmsmay25.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    @Override
    Optional<ShowSeatType> findById(Long aLong);

    List<ShowSeatType> findAllByShow(Show show);
}
