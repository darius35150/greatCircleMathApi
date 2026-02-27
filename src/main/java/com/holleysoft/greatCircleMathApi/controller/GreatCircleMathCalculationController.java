package com.holleysoft.greatCircleMathApi.controller;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathCalculationService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class GreatCircleMathCalculationController {
    GreatCircleMathCalculationService greatCircleMathCalculationService;

    public GreatCircleMathCalculationController(GreatCircleMathCalculationService greatCircleMathCalculationService){
        this.greatCircleMathCalculationService = greatCircleMathCalculationService;
    }

    @GetMapping("/getDistance")
    public ResponseEntity<GreatCircleMathCalculationDto> getGreatCircleMathCalculation(
            @RequestParam(required = true) double latA,
            @RequestParam(required = true) double longA,
            @RequestParam(required = true) double latB,
            @RequestParam(required = true) double longB,
            @RequestParam(required = false, defaultValue = "mi") String unit){

        ResponseEntity<GreatCircleMathCalculationDto> responseEntity;

        responseEntity = greatCircleMathCalculationService.calculateGreatCircleMath(latA, longA, latB, longB, unit.equalsIgnoreCase("mi") ? false : true);
        return responseEntity;
    }
}