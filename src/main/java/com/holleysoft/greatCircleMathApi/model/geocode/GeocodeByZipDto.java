package com.holleysoft.greatCircleMathApi.model.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class GeocodeByZipDto {
    String zip;
    String name;
    BigDecimal lat;
    BigDecimal lon;
    String country;
}
