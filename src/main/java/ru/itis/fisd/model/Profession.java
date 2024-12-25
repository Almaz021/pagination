package ru.itis.fisd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profession {
    private Long id;
    private String name;

    public Profession(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}