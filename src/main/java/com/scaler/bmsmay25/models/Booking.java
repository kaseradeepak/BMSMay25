package com.scaler.bmsmay25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    @ManyToOne
    private User bookedBy;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeats;

    private Date bookingDate;

    private int amount;

    @OneToMany
    private List<Payment> payments;
}


/*
   1           1
booking --- bookedBy => M:1
   M           1

   1            m
booking ---- payment => 1:M
   1            1

 */