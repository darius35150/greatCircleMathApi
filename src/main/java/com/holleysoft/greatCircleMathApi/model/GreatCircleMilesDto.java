package com.holleysoft.greatCircleMathApi.model;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class GreatCircleMilesDto {
    double distance;
    String uom;
}
