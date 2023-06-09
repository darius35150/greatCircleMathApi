package com.holleysoft.greatCircleMathApi.service;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GreatCircleMathCalculationService {

    public ResponseEntity<GreatCircleMathCalculationDto> calculateGreatCircleMath(double latA, double longA, double latB, double longB){
        return calculateGreatCircleMath(latA, longA, latB, longB, false);
    }

    public ResponseEntity<GreatCircleMathCalculationDto> calculateGreatCircleMath(double latA, double longA, double latB, double longB, boolean inKm){
        double radius = 0;
        double latitudeA = Math.toRadians(latA);
        double longitudeA = Math.toRadians(longA);
        double latitudeB = Math.toRadians(latB);
        double longitudeB = Math.toRadians(longB);

        if(inKm)
            radius = 6371;
        else
            radius = 3958.8;

        double result = radius * Math.acos(Math.cos(latitudeA) * Math.cos(latitudeB) * Math.cos(longitudeA - longitudeB) + Math.sin(latitudeA) * Math.sin(latitudeB));

        return setGreatCircleMathCalculationDto(latA, longA, latB, longB, new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue(), inKm);
    }

    private ResponseEntity<GreatCircleMathCalculationDto> setGreatCircleMathCalculationDto(double latA, double longA, double latB, double longB, double distance, boolean inKm){
        GreatCircleMathCalculationDto greatCircleMathCalculationDto = new GreatCircleMathCalculationDto();
        greatCircleMathCalculationDto.setLatitude1(latA);
        greatCircleMathCalculationDto.setLongitude1(longA);
        greatCircleMathCalculationDto.setLatitude2(latB);
        greatCircleMathCalculationDto.setLongitude2(longB);
        greatCircleMathCalculationDto.setDistance(distance);

        if(inKm)
            greatCircleMathCalculationDto.setUom("km");
        else
            greatCircleMathCalculationDto.setUom("mi");

        return new ResponseEntity<>(greatCircleMathCalculationDto, HttpStatus.OK);
    }
}