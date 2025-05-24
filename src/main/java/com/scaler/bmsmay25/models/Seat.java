package com.scaler.bmsmay25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}


/*

 1          1
Seat ----- SeatType => M:1
 M           1

 */