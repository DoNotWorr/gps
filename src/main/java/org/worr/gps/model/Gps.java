package org.worr.gps.model;

public class Gps {
    private Long id;
    private String description;

    public Gps(Long id, String description) {
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
