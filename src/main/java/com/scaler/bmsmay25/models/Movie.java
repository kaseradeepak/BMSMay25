package com.scaler.bmsmay25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "movies")
public class Movie extends BaseModel {
    private String name;
}
