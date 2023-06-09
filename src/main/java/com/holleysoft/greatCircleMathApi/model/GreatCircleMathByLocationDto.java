package com.holleysoft.greatCircleMathApi.model;

import lombok.Data;

@Data
public class GreatCircleMathByLocationDto {
    private String cityName1;
    private String stateName1;
    private String country1;
    private double latitude1;
    private double longitude1;
    private String cityName2;
    private String stateName2;
    private String country2;
    private double latitude2;
    private double longitude2;
    private GreatCircleMilesDto calculatedDist;
}
