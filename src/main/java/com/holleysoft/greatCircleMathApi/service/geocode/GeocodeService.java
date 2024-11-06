package com.holleysoft.greatCircleMathApi.service.geocode;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.holleysoft.greatCircleMathApi.model.geocode.*;

import java.util.*;

import com.holleysoft.greatCircleMathApi.util.GeocodeRestUtil;

@Service
public class GeocodeService {
    GeocodeRestUtil restUtil;

    public GeocodeService(GeocodeRestUtil restUtil) {
        this.restUtil = restUtil;
    }

    public ResponseEntity<List<GeocodeData>> getGeocodeByName(String city, String state, String countryAbbrev, String limit) {
        ResponseEntity<String> geocoodeResponse = restUtil.getGeocodeByName(city, state, countryAbbrev, limit);
        
        return mapDataToGeocodeDataDto(geocoodeResponse);
    }
    
    public ResponseEntity<GeocodeByZipDto> getGeocodeByZip(String zip, String countryAbbrev){
        ResponseEntity<String> zipResponse = restUtil.getGeocodeByZip(zip, countryAbbrev);
        return mapDataToGeocodeByZipDto(zipResponse);
    }

    public ResponseEntity<List<GeocodeData>> getGeocodeByCoordinates(String lat, String lon, String limit){
        ResponseEntity<String> coordinatesResponse = restUtil.getGeocodeByCoordinates(lat, lon, limit);
        System.out.println(coordinatesResponse.getBody());
        return mapDataToGeocodeDataDto(coordinatesResponse);
    }

    private ResponseEntity<List<GeocodeData>> mapDataToGeocodeDataDto(ResponseEntity<String> geocodeResponse) {
        List<GeocodeData> geocodeDataList = new ArrayList();
        GeocodeData geocodeData = new GeocodeData();
        // GeocodeLocalNamesDto geocodeLocalNamesDto = new GeocodeLocalNamesDto();
        JSONArray jsonArray = new JSONArray(geocodeResponse.getBody().toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).has("name")) {
                geocodeData.setName(jsonArray.getJSONObject(i).getString("name"));
            }

            // if (jsonArray.getJSONObject(i).has("local_names")) {
            //     mapLocalNamesData(jsonArray.getJSONObject(i).getJSONObject("local_names"), geocodeLocalNamesDto);
            //     geocodeData.setLocal_names(geocodeLocalNamesDto);
            // }

            if (jsonArray.getJSONObject(i).has("lat")){
                geocodeData.setLat(jsonArray.getJSONObject(i).getBigDecimal("lat"));
            }

            if (jsonArray.getJSONObject(i).has("lon")){
                geocodeData.setLon(jsonArray.getJSONObject(i).getBigDecimal("lon"));
            }

            if (jsonArray.getJSONObject(i).has("country")){
                geocodeData.setCountry(jsonArray.getJSONObject(i).getString("country"));
            }

            if (jsonArray.getJSONObject(i).has("state")){
                geocodeData.setState(jsonArray.getJSONObject(i).getString("state"));
            }
            geocodeDataList.add(geocodeData);
            geocodeData = new GeocodeData();
        }
        return new ResponseEntity<List<GeocodeData>>(geocodeDataList, HttpStatus.OK);
    }

    private void mapLocalNamesData(JSONObject object, GeocodeLocalNamesDto geocodeLocalNamesDto) {
        if (object.has("ms")){
            geocodeLocalNamesDto.setMs(object.getString("ms"));
        }
        if (object.has("gu")) {
            geocodeLocalNamesDto.setGu(object.getString("gu"));
        }
        if (object.has("is")) {
            geocodeLocalNamesDto.setIs(object.getString("is"));
        }
        if (object.has("wa")) {
            geocodeLocalNamesDto.setWa(object.getString("wa"));
        }
        if (object.has("mg")) {
            geocodeLocalNamesDto.setMg(object.getString("mg"));
        }
        if (object.has("gl")) {
            geocodeLocalNamesDto.setGl(object.getString("gl"));
        }
        if (object.has("om")) {
            geocodeLocalNamesDto.setOm(object.getString("om"));
        }
        if (object.has("ku")) {
            geocodeLocalNamesDto.setKu(object.getString("ku"));
        }
        if (object.has("tw")) {
            geocodeLocalNamesDto.setTw(object.getString("tw"));
        }
        if (object.has("mk")) {
            geocodeLocalNamesDto.setMk(object.getString("mk"));
        }
        if (object.has("ee")) {
            geocodeLocalNamesDto.setEe(object.getString("ee"));
        }
        if (object.has("fj")) {
            geocodeLocalNamesDto.setFj(object.getString("fj"));
        }
        if (object.has("gd")) {
            geocodeLocalNamesDto.setGd(object.getString("gd"));
        }
        if (object.has("ky")) {
            geocodeLocalNamesDto.setKy(object.getString("ky"));
        }
        if (object.has("yo")) {
            geocodeLocalNamesDto.setYo(object.getString("yo"));
        }
        if (object.has("zu")) {
            geocodeLocalNamesDto.setZu(object.getString("zu"));
        }
        if (object.has("bg")) {
            geocodeLocalNamesDto.setBg(object.getString("bg"));
        }
        if (object.has("tk")) {
            geocodeLocalNamesDto.setTk(object.getString("tk"));
        }
        if (object.has("co")) {
            geocodeLocalNamesDto.setCo(object.getString("co"));
        }
        if (object.has("sh")) {
            geocodeLocalNamesDto.setSh(object.getString("sh"));
        }
        if (object.has("de")) {
            geocodeLocalNamesDto.setDe(object.getString("de"));
        }
        if (object.has("kl")) {
            geocodeLocalNamesDto.setKl(object.getString("kl"));
        }
        if (object.has("bi")) {
            geocodeLocalNamesDto.setBi(object.getString("bi"));
        }
        if (object.has("km")) {
            geocodeLocalNamesDto.setKm(object.getString("km"));
        }
        if (object.has("lt")) {
            geocodeLocalNamesDto.setLt(object.getString("lt"));
        }
        if (object.has("fi")) {
            geocodeLocalNamesDto.setFi(object.getString("fi"));
        }
        if (object.has("fy")) {
            geocodeLocalNamesDto.setFy(object.getString("fy"));
        }
        if (object.has("ba")) {
            geocodeLocalNamesDto.setBa(object.getString("ba"));
        }
        if (object.has("sc")) {
            geocodeLocalNamesDto.setSc(object.getString("sc"));
        }
        if (object.has("feature_name")) {
            geocodeLocalNamesDto.setFeature_name(object.getString("feature_name"));
        }
        if (object.has("ja")) {
            geocodeLocalNamesDto.setJa(object.getString("ja"));
        }
        if (object.has("am")) {
            geocodeLocalNamesDto.setAm(object.getString("am"));
        }
        if (object.has("sk")) {
            geocodeLocalNamesDto.setSk(object.getString("sk"));
        }
        if (object.has("mr")) {
            geocodeLocalNamesDto.setMr(object.getString("mr"));
        }
        if (object.has("es")) {
            geocodeLocalNamesDto.setEs(object.getString("es"));
        }
        if (object.has("sq")) {
            geocodeLocalNamesDto.setSq(object.getString("sq"));
        }
        if (object.has("te")) {
            geocodeLocalNamesDto.setTe(object.getString("te"));
        }
        if (object.has("br")) {
            geocodeLocalNamesDto.setBr(object.getString("br"));
        }
        if (object.has("uz")) {
            geocodeLocalNamesDto.setUz(object.getString("uz"));
        }
        if (object.has("da")) {
            geocodeLocalNamesDto.setDa(object.getString("da"));
        }
        if (object.has("sw")) {
            geocodeLocalNamesDto.setSw(object.getString("sw"));
        }
        if (object.has("fa")) {
            geocodeLocalNamesDto.setFa(object.getString("fa"));
        }
        if (object.has("sr")) {
            geocodeLocalNamesDto.setSr(object.getString("sr"));
        }
        if (object.has("cu")) {
            geocodeLocalNamesDto.setCu(object.getString("cu"));
        }
        if (object.has("ln")) {
            geocodeLocalNamesDto.setLn(object.getString("ln"));
        }
        if (object.has("na")) {
            geocodeLocalNamesDto.setNa(object.getString("na"));
        }
        if (object.has("wo")) {
            geocodeLocalNamesDto.setWo(object.getString("wo"));
        }
        if (object.has("ig")) {
            geocodeLocalNamesDto.setIg(object.getString("ig"));
        }
        if (object.has("to")) {
            geocodeLocalNamesDto.setTo(object.getString("to"));
        }
        if (object.has("ta")) {
            geocodeLocalNamesDto.setTa(object.getString("ta"));
        }
        if (object.has("mt")) {
            geocodeLocalNamesDto.setMt(object.getString("mt"));
        }
        if (object.has("ar")) {
            geocodeLocalNamesDto.setAr(object.getString("ar"));
        }
        if (object.has("su")) {
            geocodeLocalNamesDto.setSu(object.getString("su"));
        }
        if (object.has("ab")) {
            geocodeLocalNamesDto.setAb(object.getString("ab"));
        }
        if (object.has("ps")) {
            geocodeLocalNamesDto.setPs(object.getString("ps"));
        }
        if (object.has("bm")) {
            geocodeLocalNamesDto.setBm(object.getString("bm"));
        }
        if (object.has("mi")) {
            geocodeLocalNamesDto.setMi(object.getString("mi"));
        }
        if (object.has("kn")) {
            geocodeLocalNamesDto.setKn(object.getString("kn"));
        }
        if (object.has("kv")) {
            geocodeLocalNamesDto.setKv(object.getString("kv"));
        }
        if (object.has("zh")) {
            geocodeLocalNamesDto.setZh(object.getString("zh"));
        }
        if (object.has("eo")) {
            geocodeLocalNamesDto.setEo(object.getString("eo"));
        }
        if (object.has("ha")) {
            geocodeLocalNamesDto.setHa(object.getString("ha"));
        }
        if (object.has("tt")) {
            geocodeLocalNamesDto.setTt(object.getString("tt"));
        }
        if (object.has("lb")) {
            geocodeLocalNamesDto.setLb(object.getString("lb"));
        }
        if (object.has("ce")) {
            geocodeLocalNamesDto.setCe(object.getString("ce"));
        }
        if (object.has("hu")) {
            geocodeLocalNamesDto.setHu(object.getString("hu"));
        }
        if (object.has("it")) {
            geocodeLocalNamesDto.setIt(object.getString("it"));
        }
        if (object.has("tl")) {
            geocodeLocalNamesDto.setTl(object.getString("tl"));
        }
        if (object.has("pl")) {
            geocodeLocalNamesDto.setPl(object.getString("pl"));
        }
        if (object.has("sm")) {
            geocodeLocalNamesDto.setSm(object.getString("sm"));
        }
        if (object.has("en")) {
            geocodeLocalNamesDto.setEn(object.getString("en"));
        }
        if (object.has("vo")) {
            geocodeLocalNamesDto.setVo(object.getString("vo"));
        }
        if (object.has("el")) {
            geocodeLocalNamesDto.setEl(object.getString("el"));
        }
        if (object.has("sn")) {
            geocodeLocalNamesDto.setSn(object.getString("sn"));
        }
        if (object.has("fr")) {
            geocodeLocalNamesDto.setFr(object.getString("fr"));
        }
        if (object.has("cs")) {
            geocodeLocalNamesDto.setCs(object.getString("cs"));
        }
        if (object.has("io")) {
            geocodeLocalNamesDto.setIo(object.getString("io"));
        }
        if (object.has("hi")) {
            geocodeLocalNamesDto.setHi(object.getString("hi"));
        }
        if (object.has("et")) {
            geocodeLocalNamesDto.setEt(object.getString("et"));
        }
        if (object.has("pa")) {
            geocodeLocalNamesDto.setPa(object.getString("pa"));
        }
        if (object.has("av")) {
            geocodeLocalNamesDto.setAv(object.getString("av"));
        }
        if (object.has("ko")) {
            geocodeLocalNamesDto.setKo(object.getString("ko"));
        }
        if (object.has("bh")) {
            geocodeLocalNamesDto.setBh(object.getString("bh"));
        }
        if (object.has("yi")) {
            geocodeLocalNamesDto.setYi(object.getString("yi"));
        }
        if (object.has("sl")) {
            geocodeLocalNamesDto.setSl(object.getString("sl"));
        }
        if (object.has("hr")) {
            geocodeLocalNamesDto.setHr(object.getString("hr"));
        }
        if (object.has("si")) {
            geocodeLocalNamesDto.setSi(object.getString("si"));
        }
        if (object.has("so")) {
            geocodeLocalNamesDto.setSo(object.getString("so"));
        }
        if (object.has("gn")) {
            geocodeLocalNamesDto.setGn(object.getString("gn"));
        }
        if (object.has("ay")) {
            geocodeLocalNamesDto.setAy(object.getString("ay"));
        }
        if (object.has("se")) {
            geocodeLocalNamesDto.setSe(object.getString("se"));
        }
        if (object.has("sd")) {
            geocodeLocalNamesDto.setSd(object.getString("sd"));
        }
        if (object.has("af")) {
            geocodeLocalNamesDto.setAf(object.getString("af"));
        }
        if (object.has("ga")) {
            geocodeLocalNamesDto.setGa(object.getString("ga"));
        }
        if (object.has("or")) {
            geocodeLocalNamesDto.setOr(object.getString("or"));
        }
        if (object.has("ia")) {
            geocodeLocalNamesDto.setIa(object.getString("ia"));
        }
        if (object.has("ie")) {
            geocodeLocalNamesDto.setIe(object.getString("ie"));
        }
        if (object.has("ug")) {
            geocodeLocalNamesDto.setUg(object.getString("ug"));
        }
        if (object.has("nl")) {
            geocodeLocalNamesDto.setNl(object.getString("nl"));
        }
        if (object.has("gv")) {
            geocodeLocalNamesDto.setGv(object.getString("gv"));
        }
        if (object.has("qu")) {
            geocodeLocalNamesDto.setQu(object.getString("qu"));
        }
        if (object.has("be")) {
            geocodeLocalNamesDto.setBe(object.getString("be"));
        }
        if (object.has("an")) {
            geocodeLocalNamesDto.setAn(object.getString("an"));
        }
        if (object.has("fo")) {
            geocodeLocalNamesDto.setFo(object.getString("fo"));
        }
        if (object.has("hy")) {
            geocodeLocalNamesDto.setHy(object.getString("hy"));
        }
        if (object.has("nv")) {
            geocodeLocalNamesDto.setNv(object.getString("nv"));
        }
        if (object.has("bo")) {
            geocodeLocalNamesDto.setBo(object.getString("bo"));
        }
        if (object.has("ascii")) {
            geocodeLocalNamesDto.setAscii(object.getString("ascii"));
        }
        if (object.has("id")) {
            geocodeLocalNamesDto.setId(object.getString("id"));
        }
        if (object.has("lv")) {
            geocodeLocalNamesDto.setLv(object.getString("lv"));
        }
        if (object.has("ca")) {
            geocodeLocalNamesDto.setCa(object.getString("ca"));
        }
        if (object.has("no")) {
            geocodeLocalNamesDto.setNo(object.getString("no"));
        }
        if (object.has("nn")) {
            geocodeLocalNamesDto.setNn(object.getString("nn"));
        }
        if (object.has("ml")) {
            geocodeLocalNamesDto.setMl(object.getString("ml"));
        }
        if (object.has("my")) {
            geocodeLocalNamesDto.setMy(object.getString("my"));
        }
        if (object.has("ne")) {
            geocodeLocalNamesDto.setNe(object.getString("ne"));
        }
        if (object.has("he")) {
            geocodeLocalNamesDto.setHe(object.getString("he"));
        }
        if (object.has("cy")) {
            geocodeLocalNamesDto.setCy(object.getString("cy"));
        }
        if (object.has("lo")) {
            geocodeLocalNamesDto.setLo(object.getString("lo"));
        }
        if (object.has("jv")) {
            geocodeLocalNamesDto.setJv(object.getString("jv"));
        }
        if (object.has("sv")) {
            geocodeLocalNamesDto.setSv(object.getString("sv"));
        }
        if (object.has("mn")) {
            geocodeLocalNamesDto.setMn(object.getString("mn"));
        }
        if (object.has("tg")) {
            geocodeLocalNamesDto.setTg(object.getString("tg"));
        }
        if (object.has("kw")) {
            geocodeLocalNamesDto.setKw(object.getString("kw"));
        }
        if (object.has("cv")) {
            geocodeLocalNamesDto.setCv(object.getString("cv"));
        }
        if (object.has("az")) {
            geocodeLocalNamesDto.setAz(object.getString("az"));
        }
        if (object.has("oc")) {
            geocodeLocalNamesDto.setOc(object.getString("oc"));
        }
        if (object.has("th")) {
            geocodeLocalNamesDto.setTh(object.getString("th"));
        }
        if (object.has("ru")) {
            geocodeLocalNamesDto.setRu(object.getString("ru"));
        }
        if (object.has("ny")) {
            geocodeLocalNamesDto.setNy(object.getString("ny"));
        }
        if (object.has("bs")) {
            geocodeLocalNamesDto.setBs(object.getString("bs"));
        }
        if (object.has("st")) {
            geocodeLocalNamesDto.setSt(object.getString("st"));
        }
        if (object.has("ro")) {
            geocodeLocalNamesDto.setRo(object.getString("ro"));
        }
        if (object.has("rm")) {
            geocodeLocalNamesDto.setRm(object.getString("rm"));
        }
        if (object.has("ff")) {
            geocodeLocalNamesDto.setFf(object.getString("ff"));
        }
        if (object.has("kk")) {
            geocodeLocalNamesDto.setKk(object.getString("kk"));
        }
        if (object.has("uk")) {
            geocodeLocalNamesDto.setUk(object.getString("uk"));
        }
        if (object.has("pt")) {
            geocodeLocalNamesDto.setPt(object.getString("pt"));
        }
        if (object.has("tr")) {
            geocodeLocalNamesDto.setTr(object.getString("tr"));
        }
        if (object.has("eu")) {
            geocodeLocalNamesDto.setEu(object.getString("eu"));
        }
        if (object.has("ht")) {
            geocodeLocalNamesDto.setHt(object.getString("ht"));
        }
        if (object.has("ka")) {
            geocodeLocalNamesDto.setKa(object.getString("ka"));
        }
        if (object.has("ur")) {
            geocodeLocalNamesDto.setUr(object.getString("ur"));
        }
    }

    private ResponseEntity<GeocodeByZipDto> mapDataToGeocodeByZipDto(ResponseEntity<String> zipResponse){

        GeocodeByZipDto zipData = new GeocodeByZipDto();
        JSONObject jsonObject = new JSONObject(zipResponse.getBody().toString());
        
        if(jsonObject.has("zip")){
            zipData.setZip(jsonObject.getString("zip"));;
        }

        if(jsonObject.has("name")){
            zipData.setName(jsonObject.getString("name"));;
        }

        if(jsonObject.has("lat")){
            zipData.setLat(jsonObject.getBigDecimal("lat"));;
        }

        if(jsonObject.has("lon")){
            zipData.setLon(jsonObject.getBigDecimal("lon"));;
        }

        if(jsonObject.has("country")){
            zipData.setCountry(jsonObject.getString("country"));;
        }

        return new ResponseEntity<GeocodeByZipDto>(zipData, HttpStatus.OK);
    }
}
