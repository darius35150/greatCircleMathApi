package com.holleysoft.greatCircleMathApi.model;

import lombok.Data;

@Data
public class GreatCircleMathCalculationDto {
    double latitudeA;
    double longitudeA;
    double latitudeB;
    double longitudeB;
    double distance;
    String uom;
}
