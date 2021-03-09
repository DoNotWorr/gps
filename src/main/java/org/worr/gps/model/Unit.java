package org.worr.gps.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unitId;

    //todo Helper methods for bidirectional associations? https://youtu.be/tciSOIQngig?t=449
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "usage_description", length=50, nullable = false)
    private String usageDescription;

    public Unit() {
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getUsageDescription() {
        return usageDescription;
    }

    public void setUsageDescription(String usageDescription) {
        this.usageDescription = usageDescription;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", ownerId=" + owner.getOwnerId() +
                ", usageDescription='" + usageDescription + '\'' +
                '}';
    }
}


