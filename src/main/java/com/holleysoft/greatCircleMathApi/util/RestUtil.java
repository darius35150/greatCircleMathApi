package com.holleysoft.greatCircleMathApi.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathCalculationDto;
import com.holleysoft.greatCircleMathApi.model.GreatCircleMilesDto;
import com.holleysoft.greatCircleMathApi.service.GreatCircleMathCalculationService;
import org.apache.coyote.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.holleysoft.greatCircleMathApi.model.GreatCircleMathByLocationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;

public class RestUtil {
    GreatCircleMathCalculationService greatCircleMathCalculationService = new GreatCircleMathCalculationService();
    RestTemplate restTemplate = new RestTemplate();
    Logger logger = LoggerFactory.getLogger(RestUtil.class);
    String geocodeBaseURL = "http://api.openweathermap.org/geo/1.0/direct?q=";
    String key = "9e00e7490b3e4fe0221f432d8767a854";

    @Autowired
    public RestUtil(){
    }

    public GreatCircleMathByLocationDto getCitiesLatLong(String city1, String state1, String country1,
                                                            String city2, String state2, String country2, boolean inKm){
                                                                
        String url;
        GreatCircleMathByLocationDto greatCircleMathByLocationDto = new GreatCircleMathByLocationDto();

        url = geocodeBaseURL + city1 + "," + state1 + "," + country1 + "&limit=1&appid=" + key;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        JSONArray jsonArray = new JSONArray(responseEntity.getBody().toString());
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        mapResponseToDto(greatCircleMathByLocationDto, jsonObject, null, true);

        url = "";
        url = geocodeBaseURL + city2 + "," + state2 + "," + country2 + "&limit=1&appid=" + key;
        responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        jsonArray = new JSONArray(responseEntity.getBody().toString());
        jsonObject = jsonArray.getJSONObject(0);
        mapResponseToDto(greatCircleMathByLocationDto, jsonObject, null, false);
        calculateMiles(greatCircleMathByLocationDto, inKm);
        return greatCircleMathByLocationDto;
    }

    private GreatCircleMathByLocationDto calculateMiles(GreatCircleMathByLocationDto locationList, boolean inKm){
        double latA, longA, latB, longB;
        latA = locationList.getLatitude1();
        longA = locationList.getLongitude1();
;
        latB = locationList.getLatitude2();
        longB = locationList.getLongitude2();

        ResponseEntity<GreatCircleMathCalculationDto> calculationEntity = greatCircleMathCalculationService.calculateGreatCircleMath(latA, longA, latB, longB, inKm);
        return mapResponseToDto(locationList, null, calculationEntity, false);
    }

    private GreatCircleMathByLocationDto mapResponseToDto(GreatCircleMathByLocationDto greatCircleMathByLocationDto, JSONObject responseObject, ResponseEntity<GreatCircleMathCalculationDto> calEntity, boolean firstLocation){
        if(Objects.nonNull(calEntity)){
            GreatCircleMilesDto greatCircleMilesDto = new GreatCircleMilesDto();
            greatCircleMilesDto.setUom(calEntity.getBody().getUom());
            greatCircleMilesDto.setDistance(calEntity.getBody().getDistance());

            greatCircleMathByLocationDto.setCalculatedDist(greatCircleMilesDto);

        }
        else if(firstLocation){
            greatCircleMathByLocationDto.setLatitude1(Double.parseDouble(responseObject.get("lat").toString()));
            greatCircleMathByLocationDto.setLongitude1(Double.parseDouble(responseObject.get("lon").toString()));
            greatCircleMathByLocationDto.setCityName1(responseObject.get("name").toString());
            greatCircleMathByLocationDto.setStateName1(responseObject.get("state").toString());
            greatCircleMathByLocationDto.setCountry1(responseObject.get("country").toString());
        }else{
            greatCircleMathByLocationDto.setLatitude2(Double.parseDouble(responseObject.get("lat").toString()));
            greatCircleMathByLocationDto.setLongitude2(Double.parseDouble(responseObject.get("lon").toString()));
            greatCircleMathByLocationDto.setCityName2(responseObject.get("name").toString());
            greatCircleMathByLocationDto.setStateName2(responseObject.get("state").toString());
            greatCircleMathByLocationDto.setCountry2(responseObject.get("country").toString());
        }

        return greatCircleMathByLocationDto;
    }
}