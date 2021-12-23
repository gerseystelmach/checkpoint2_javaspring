package com.example.demo.repository;

import com.example.demo.entity.CountryTravel;
import com.example.demo.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    @Query("SELECT e FROM Destination e ORDER BY e.startDate ASC")
    List<CountryTravel> findAllDestinations();

/*    @Query("SELECT d FROM Destination d WHERE d.country = :country")
    List<CountryTravel> findAllDestinationsByCountry(@Param("country") String country);*/

}
