package com.holleysoft.greatCircleMathApi.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GeocodeRestUtil {
    WebClient webClient = WebClient.create();
    String key = "0e45d113947a0ca900ecd68644300041";

    GeocodeRestUtil(){
    }   

    public ResponseEntity<String> getGeocodeByName(String city, String state, String countryAbbrev, String limit){
        ResponseEntity<String> data = null;
        String queryUrl = "http://api.openweathermap.org/geo/1.0/direct?q=";
        String limitString = "&limit=" + limit;
        String appIdString = "&appid=".concat(key);
        String completeUrl = queryUrl.concat(city).concat(!Objects.isNull(state) ? "," + state : "")
                                        .concat(!Objects.isNull(countryAbbrev) ? "," + countryAbbrev : "")
                                        .concat(!Objects.isNull(limit) ? limitString + appIdString : appIdString);
        try {
            URI url = new URI(completeUrl);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ResponseEntity<String> getGeocodeByZip(String zip, String conuntryAbbrev){
        ResponseEntity<String> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/zip?zip=" + zip + (conuntryAbbrev != null ? "," + conuntryAbbrev : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ResponseEntity<String> getGeocodeByCoordinates(String lat, String lon, String limit){
        ResponseEntity<String> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/reverse?lat=" + lat + "&lon=" + lon + (limit != null ? "&limit=" + limit : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }
}
