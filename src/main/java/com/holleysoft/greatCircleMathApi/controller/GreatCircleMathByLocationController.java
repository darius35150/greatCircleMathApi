package com.holleysoft.greatCircleMathApi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathByLocationDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathByLocationService;

import java.util.ArrayList;

@RestController
@RequestMapping("/byLocation")
public class GreatCircleMathByLocationController {
    GreatCircleMathByLocationService gCircleMathByLocationService;

    @Autowired
    GreatCircleMathByLocationController(GreatCircleMathByLocationService gCircleMathByLocationService){
        this.gCircleMathByLocationService = gCircleMathByLocationService;
    }

    @GetMapping("/byCityStateCountry/{city1}/{state1}/{country1}/{city2}/{state2}/{country2}")
    public ResponseEntity<GreatCircleMathByLocationDto> getMilesByCityState(@PathVariable("city1") String city1,
                                                                            @PathVariable("state1") String state1,
                                                                            @PathVariable("country1") String country1,
                                                                            @PathVariable("city2") String city2,
                                                                            @PathVariable("state2") String state2,
                                                                            @PathVariable("country2") String country2){
        ResponseEntity<GreatCircleMathByLocationDto> responseEntity;
        
        responseEntity = gCircleMathByLocationService.getMilesByCityState(city1, state1, country1, city2, state2, country2, false);
        
        return responseEntity;
    }

    @GetMapping("/byCityStateCountryKm/{city1}/{state1}/{country1}/{city2}/{state2}/{country2}")
    public ResponseEntity<GreatCircleMathByLocationDto> getMilesByCityStateKm(@PathVariable("city1") String city1,
                                                                            @PathVariable("state1") String state1,
                                                                            @PathVariable("country1") String country1,
                                                                            @PathVariable("city2") String city2,
                                                                            @PathVariable("state2") String state2,
                                                                            @PathVariable("country2") String country2){
        ResponseEntity<GreatCircleMathByLocationDto> responseEntity;

        responseEntity = gCircleMathByLocationService.getMilesByCityState(city1, state1, country1, city2, state2, country2, true);

        return responseEntity;
    }
}
