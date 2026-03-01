package com.holleysoft.greatCircleMathApi.controller;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathCalculationService;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
@Validated
public class GreatCircleMathCalculationController {
    GreatCircleMathCalculationService greatCircleMathCalculationService;

    public GreatCircleMathCalculationController(GreatCircleMathCalculationService greatCircleMathCalculationService){
        this.greatCircleMathCalculationService = greatCircleMathCalculationService;
    }

    @GetMapping("/getDistance")
    public ResponseEntity<GreatCircleMathCalculationDto> getGreatCircleMathCalculation(
            @RequestParam(required = true) 
            @NotNull(message = "latA is required")
            @DecimalMin(value="-90.0", message = "latA must be >=-90 ") 
            @DecimalMax(value="90.0", message = "latA must be <= 90") double latA,
            @RequestParam(required = true) 
            @NotNull(message = "longA is required") 
            @DecimalMin(value="-180.0", message = "longA must be >= -180") 
            @DecimalMax(value="180.0", message = "longA must be <= 180") double longA,
            @RequestParam(required = true) 
            @NotNull(message = "latB is required") 
            @DecimalMin(value="-90.0", message = "latB must be >= -90") 
            @DecimalMax(value="90.0", message = "latB must be <= 90") double latB,
            @RequestParam(required = true) 
            @NotNull(message = "longB is required") 
            @DecimalMin(value="-180.0", message = "longB must be >= -180") 
            @DecimalMax(value="180.0", message = "longB must be <= 180") double longB,
            @RequestParam(required = false, defaultValue = "mi") String unit){

        ResponseEntity<GreatCircleMathCalculationDto> responseEntity;

        responseEntity = greatCircleMathCalculationService.calculateGreatCircleMath(latA, longA, latB, longB, unit.equalsIgnoreCase("mi") ? false : true);
        return responseEntity;
    }
}