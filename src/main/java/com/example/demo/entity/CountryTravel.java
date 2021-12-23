package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class CountryTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Destination> destinations;

    public CountryTravel() {
    }

    public CountryTravel(Long id, String country, Date startDate, Date endDate) {
        this.id = id;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
