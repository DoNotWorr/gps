package org.worr.gps.model;

public class Unit {
    private Long id;
    private String description;

    public Unit(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}