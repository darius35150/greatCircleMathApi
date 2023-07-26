package com.holleysoft.greatCircleMathApi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathByLocationDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathByLocationService;


@RestController
@RequestMapping("/byLocation")
public class GreatCircleMathByLocationController {
    GreatCircleMathByLocationService gCircleMathByLocationService;

    GreatCircleMathByLocationController(GreatCircleMathByLocationService gCircleMathByLocationService){
        this.gCircleMathByLocationService = gCircleMathByLocationService;
    }

    @GetMapping("/byCityStateCountry/{city1}/{state1}/{country1}/{city2}/{state2}/{country2}")
    public ResponseEntity<GreatCircleMathByLocationDto> getMilesByCityState(@PathVariable String city1,
            @PathVariable String state1,
            @PathVariable String country1,
            @PathVariable String city2,
            @PathVariable String state2,
            @PathVariable String country2){
        ResponseEntity<GreatCircleMathByLocationDto> responseEntity;
        
        responseEntity = gCircleMathByLocationService.getMilesByCityState(city1, state1, country1, city2, state2, country2, false);
        
        return responseEntity;
    }

    @GetMapping("/byCityStateCountryKm/{city1}/{state1}/{country1}/{city2}/{state2}/{country2}")
    public ResponseEntity<GreatCircleMathByLocationDto> getMilesByCityStateKm(@PathVariable String city1,
            @PathVariable String state1,
            @PathVariable String country1,
            @PathVariable String city2,
            @PathVariable String state2,
            @PathVariable String country2){
        ResponseEntity<GreatCircleMathByLocationDto> responseEntity;

        responseEntity = gCircleMathByLocationService.getMilesByCityState(city1, state1, country1, city2, state2, country2, true);

        return responseEntity;
    }
}
