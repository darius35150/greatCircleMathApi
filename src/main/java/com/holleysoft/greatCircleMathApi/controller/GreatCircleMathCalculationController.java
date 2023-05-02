package com.holleysoft.greatCircleMathApi.controller;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/circleMath")
public class GreatCircleMathCalculationController {
    GreatCircleMathCalculationService greatCircleMathCalculationService;

    @Autowired
    public GreatCircleMathCalculationController(GreatCircleMathCalculationService greatCircleMathCalculationService){
        this.greatCircleMathCalculationService = greatCircleMathCalculationService;
    }

    @GetMapping("/getDistance/{latA}/{longA}/{latB}/{longB}")
    public ResponseEntity<GreatCircleMathCalculationDto> getGreatCircleMathCalculation(
            @PathVariable double latA,
            @PathVariable double longA,
            @PathVariable double latB,
            @PathVariable double longB){

        ResponseEntity<GreatCircleMathCalculationDto> responseEntity;
        responseEntity = greatCircleMathCalculationService.calculateGreatCircleMath(latA, longA, latB, longB);

        return responseEntity;
    }
}