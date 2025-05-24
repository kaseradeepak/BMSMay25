package com.scaler.bmsmay25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theatres")
public class Theatre extends BaseModel {
    private String name;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city;
}

/*
  1             M
Theatre ----- Screen => 1:M
  1             1

   1           1
Theatre ----- City => M:1
   M           1

 */
