package org.worr.gps.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;

    //todo Helper methods for bidirectional associations? https://youtu.be/tciSOIQngig?t=449
    @JsonManagedReference
    @OneToMany(mappedBy = "owner")
    private Set<Unit> units;

    @Column(name = "company_name", length=50, nullable = false)
    private String companyName;

    public Owner() {
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
