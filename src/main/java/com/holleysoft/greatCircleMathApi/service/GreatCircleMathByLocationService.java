package com.holleysoft.greatCircleMathApi.service;

import com.holleysoft.greatCircleMathApi.util.RestUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathByLocationDto;

@Service
public class GreatCircleMathByLocationService {
    RestUtil restUtil = new RestUtil();
    GreatCircleMathCalculationService greatCircleMathCalculationService = new GreatCircleMathCalculationService();

    GreatCircleMathByLocationService(){
    }
    
    public ResponseEntity<GreatCircleMathByLocationDto> getMilesByCityState(String city1, String state1, String country1,
                                                                                    String city2, String state2, String country2,
                                                                                    boolean inKm){
        
        GreatCircleMathByLocationDto greatCircleMathByLocationDto = restUtil.getCitiesLatLong(city1, state1, country1, city2, state2, country2, inKm);
                                                                                        
        return new ResponseEntity<GreatCircleMathByLocationDto>(greatCircleMathByLocationDto,HttpStatus.OK);
    }
}
