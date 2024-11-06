package com.holleysoft.greatCircleMathApi.model.geocode;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class GeocodeDataDto {
    List<GeocodeData> data;
}
