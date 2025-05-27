package com.scaler.bmsmay25.controllers;

import com.scaler.bmsmay25.dtos.BookMovieRequestDto;
import com.scaler.bmsmay25.dtos.BookMovieResponseDto;
import com.scaler.bmsmay25.dtos.ResponseStatus;
import com.scaler.bmsmay25.exceptions.ShowNotFoundException;
import com.scaler.bmsmay25.exceptions.ShowSeatNotAvailableException;
import com.scaler.bmsmay25.exceptions.UserNotFoundException;
import com.scaler.bmsmay25.models.Booking;
import com.scaler.bmsmay25.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) {
        BookMovieResponseDto responseDto = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(
                    requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds()
            );

            responseDto.setBooking(booking);
            responseDto.setStatus(ResponseStatus.SUCCESS);

            return responseDto;
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (ShowNotFoundException e) {
            e.printStackTrace();
        } catch (ShowSeatNotAvailableException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        responseDto.setStatus(ResponseStatus.FAILURE);
        return responseDto;
    }
}
