package com.holleysoft.greatCircleMathApi.service;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GreatCircleMathCalculationService {

    public ResponseEntity<GreatCircleMathCalculationDto> calculateGreatCircleMath(double latA, double longA, double latB, double longB){
        double radius = 3958.76;
        double latitudeA = Math.toRadians(latA);
        double longitudeA = Math.toRadians(longA);
        double latitudeB = Math.toRadians(latB);
        double longitudeB = Math.toRadians(longB);

        double result = radius * Math.acos(Math.cos(latitudeA) * Math.cos(latitudeB) * Math.cos(longitudeA - longitudeB) + Math.sin(latitudeA) * Math.sin(latitudeB));

        return setGreatCircleMathCalculationDto(latA, longA, latB, longB, result);
    }

    private ResponseEntity<GreatCircleMathCalculationDto> setGreatCircleMathCalculationDto(double latA, double longA, double latB, double longB, double distance){
        GreatCircleMathCalculationDto greatCircleMathCalculationDto = new GreatCircleMathCalculationDto();
        greatCircleMathCalculationDto.setLatitudeA(latA);
        greatCircleMathCalculationDto.setLongitudeA(longA);
        greatCircleMathCalculationDto.setLatitudeB(latB);
        greatCircleMathCalculationDto.setLongitudeB(longB);
        greatCircleMathCalculationDto.setGreatCircleMiles(distance);

        return new ResponseEntity<>(greatCircleMathCalculationDto, HttpStatus.OK);
    }
}