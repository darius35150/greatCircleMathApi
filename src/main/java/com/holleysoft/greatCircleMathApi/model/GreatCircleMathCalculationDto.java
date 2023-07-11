package com.holleysoft.greatCircleMathApi.model;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class GreatCircleMathCalculationDto {
    double latitude1;
    double longitude1;
    double latitude2;
    double longitude2;
    double distance;
    String uom;
}
