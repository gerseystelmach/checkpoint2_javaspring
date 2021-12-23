package com.example.demo.repository;

import com.example.demo.entity.CountryTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryTravelRepository extends JpaRepository<CountryTravel, Long> {

    @Query("SELECT e FROM CountryTravel e ORDER BY e.country ASC")
    List<CountryTravel> findAllCountryTravels();

    CountryTravel getCountryTravelById(Long id);
}
