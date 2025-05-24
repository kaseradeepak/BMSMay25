package com.scaler.bmsmay25.dtos;

import com.scaler.bmsmay25.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus status;
}
