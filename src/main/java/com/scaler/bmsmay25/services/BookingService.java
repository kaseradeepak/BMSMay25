package com.scaler.bmsmay25.services;

import com.scaler.bmsmay25.exceptions.ShowNotFoundException;
import com.scaler.bmsmay25.exceptions.ShowSeatNotAvailableException;
import com.scaler.bmsmay25.exceptions.UserNotFoundException;
import com.scaler.bmsmay25.models.*;
import com.scaler.bmsmay25.repositories.BookingRepository;
import com.scaler.bmsmay25.repositories.ShowRepository;
import com.scaler.bmsmay25.repositories.ShowSeatRepository;
import com.scaler.bmsmay25.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculationService priceCalculationService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculationService priceCalculationService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " doesn't exist.");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with id: " + showId + " doesn't exist.");
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("Show Seat not available, Please try some other seats.");
            }
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookingDate(new Date());
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculationService.calculatePrice(showSeats));

        booking = bookingRepository.save(booking);

        return booking;
    }
}

//1. Get the user details from DB.
//2. Get the show details from DB.
//3. Get the list of show seats from the DB.
//4. Check if all the seats are AVAILABLE.
// --------- TAKE A LOCK ----------------
//5. Check again if the seats are AVAILABLE or not.
//6. If no, throw an exception.
//7. If yes, mark the seat status as BLOCKED.
// --------- RELEASE THE LOCK ------------
//8. Create the ticket/booking object.
//9. Proceed to the payment.