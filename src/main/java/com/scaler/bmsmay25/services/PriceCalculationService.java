package com.scaler.bmsmay25.services;

import com.scaler.bmsmay25.models.Show;
import com.scaler.bmsmay25.models.ShowSeat;
import com.scaler.bmsmay25.models.ShowSeatType;
import com.scaler.bmsmay25.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    int amount = 0;
    public int calculatePrice(List<ShowSeat> showSeats) {
        Show show = showSeats.get(0).getShow();

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }

        return amount;
    }
}
