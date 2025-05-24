package com.scaler.bmsmay25.controllers;

import com.scaler.bmsmay25.dtos.BookMovieRequestDto;
import com.scaler.bmsmay25.dtos.BookMovieResponseDto;
import com.scaler.bmsmay25.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) {
        return null;
    }
}
