package com.scaler.bmsmay25.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel {
    private List<Seat> seats;
    private List<Feature> features;
}
