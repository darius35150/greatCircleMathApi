package com.holleysoft.greatCircleMathApi.controller.geocode;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holleysoft.greatCircleMathApi.model.geocode.*;
import com.holleysoft.greatCircleMathApi.service.geocode.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/geocode")
public class GeocodeController {
    GeocodeService geocodeService;
    public GeocodeController(GeocodeService geocodeService){
        this.geocodeService = geocodeService;
    }

    @GetMapping("/byName")
    public ResponseEntity<List<GeocodeData>> getGeocodeByName(
        @RequestParam("city") String city,
        @RequestParam(value = "state", required = false) String state,
        @RequestParam(value="countryAbbrev", required= false) String countryAbbrev,
        @RequestParam(value = "limit", required=false) String limit
        ) {
        ResponseEntity<List<GeocodeData>> geocoodeResponse = geocodeService.getGeocodeByName(city, state, countryAbbrev, limit);
        return geocoodeResponse;
    }

    @GetMapping("/byZip/{zip}")
    public ResponseEntity<GeocodeByZipDto> getMethodName(@PathVariable String zip, 
    @RequestParam(value = "countryAbbrev", required = false) String countryAbbrev) {

        ResponseEntity<GeocodeByZipDto> zipResponse = geocodeService.getGeocodeByZip(zip, countryAbbrev);
        return zipResponse;
    }
    
    @GetMapping("byCoordinates/{lat}/{lon}")
    public ResponseEntity<List<GeocodeData>> getMethodName(
        @PathVariable String lat, @PathVariable String lon, @RequestParam(value = "limit", required = false) String limit) {
            ResponseEntity<List<GeocodeData>> latLonResponse = geocodeService.getGeocodeByCoordinates(lat, lon, limit);
            return latLonResponse;
    }
    
    
}
