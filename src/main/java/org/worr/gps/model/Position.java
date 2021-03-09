package org.worr.gps.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.postgis.Geometry;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
Herman har skickat
Men long lat, tid datum och ett id på enheten finns väl
Sen får du skapa en unik nyckel till primärnyckel och bara tjoffa in den
 */

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(name = "longitude", length = 50, nullable = false)
    private String longitude;

    @Column(name = "latitude", length = 50, nullable = false)
    private String latitude;

    /*
    //Todo revisit Geometry when things work
    @Column(name = "long_lat", nullable = false)
    private Geometry longLat;
     */

    @Column(name = "sent_on", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime sentOn;

    public Position() {
    }

    public Position(Unit unit, String longitude, String latitude, LocalDateTime sentOn) {
        this.unit = unit;
        this.longitude = longitude;
        this.latitude = latitude;
        this.sentOn = sentOn;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getSentOn() {
        return sentOn;
    }

    public void setSentOn(LocalDateTime sentOn) {
        this.sentOn = sentOn;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", unitId=" + unit.getUnitId() +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", sentOn=" + sentOn +
                '}';
    }
}
