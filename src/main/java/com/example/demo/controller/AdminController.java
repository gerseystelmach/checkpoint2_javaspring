package com.example.demo.controller;

import com.example.demo.entity.CountryTravel;
import com.example.demo.entity.Destination;
import com.example.demo.repository.CountryTravelRepository;
import com.example.demo.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CountryTravelRepository countryTravelRepository;

    @Autowired
    DestinationRepository destinationRepository;

    @GetMapping("/mytrips")
    public String showMyTravelledCountries(Model model, Principal principal) {

        if (principal == null) {
            return "redirect: /login";
        }

        String username = principal.getName();
        model.addAttribute("user", username);
        model.addAttribute("countries", countryTravelRepository.findAllCountryTravels());
        return "adminAll";
    }

    @GetMapping("/mytrips/country/{countryId}/destinations")
    public String showMyCountryDestinations(@ModelAttribute CountryTravel countryTravel, @PathVariable Long countryId, Model model, Principal principal) {

        if (principal == null) {
            return "redirect: /login";
        }
        CountryTravel countryTravelId = countryTravelRepository.getCountryTravelById(countryId);
/*        model.addAttribute("destinationsFromCountryTravel", destinationRepository.findAllDestinationsByCountry(countryTravelId.getCountry()));*/
        model.addAttribute("destinations", countryTravelId.getDestinations());
        model.addAttribute("countryTravelId", countryTravelId);

        return "adminAllDestinations";
    }

    /* COUNTRYTRAVEL CRUD */

    @GetMapping("/createCountryTravel")
    public String createCountryTravel(Model model, Principal principal) {
        model.addAttribute("countryTravel", new CountryTravel());
        return "adminCreateCountryTravel";
    }

    @PostMapping("/createCountryTravel")
    public String saveCountryTravel(@Valid @ModelAttribute CountryTravel countryTravel,
                                    Model model,
                                    Principal principal
    ) {
        countryTravelRepository.save(countryTravel);
        return "redirect:/admin/mytrips";
    }

    /* DESTINATION CRUD */

    @GetMapping("/createDestination")
    public String createDestination(Model model, Principal principal) {
        List<CountryTravel> countriesTravel = countryTravelRepository.findAllCountryTravels();
        model.addAttribute("countriesTravel", countriesTravel);
        model.addAttribute("destination", new Destination());

        return "adminCreateDestination";
    }

    @PostMapping("/createDestination")
    public String saveDestination(@Valid @ModelAttribute Destination destination,
                                  Model model,
                                  Principal principal
    ) {

        List<CountryTravel> countriesTravel = countryTravelRepository.findAllCountryTravels();
        model.addAttribute("countriesTravel", countriesTravel);
        destinationRepository.save(destination);
        return "redirect:/admin/mytrips";
    }
}


