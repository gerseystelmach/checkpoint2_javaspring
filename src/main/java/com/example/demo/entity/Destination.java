package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private Date startDate;

    private Date endDate;

    private String resume;

    private String mainCoverImage;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private CountryTravel country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public CountryTravel getCountry() {
        return country;
    }

    public void setCountry(CountryTravel country) {
        this.country = country;
    }

    public String getMainCoverImage() {
        return mainCoverImage;
    }

    public void setMainCoverImage(String mainCoverImage) {
        this.mainCoverImage = mainCoverImage;
    }


    public String getFormatedStartDate() {
        String dateString = startDate.toString();
        String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(dateString);
    }

    public String getFormatedEndDate() {
        String dateString = endDate.toString();
        String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(dateString);
    }

}
