package com.scaler.bmsmay25.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre {
    private String name;
    private List<Screen> screens;
    private City city;
}
