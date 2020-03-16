package tryer.objectmapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Map;

public class ObjectMapperTest  {

    static String json = "{\n" +
            "  \"coord\": {\n" +
            "    \"lon\": 25.61,\n" +
            "    \"lat\": 49.56\n" +
            "  },\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 804,\n" +
            "      \"main\": \"Clouds\",\n" +
            "      \"description\": \"хмарно\",\n" +
            "      \"icon\": \"04n\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"model\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 1.06,\n" +
            "    \"feels_like\": -2.27, \n" +
            "    \"temp_min\": 1.06,\n" +
            "    \"temp_max\": 1.06,\n" +
            "    \"pressure\": 1016,  \n" +
            "    \"humidity\": 84,\n" +
            "    \"sea_level\": 1016,\n" +
            "    \"grnd_level\": 974\n" +
            "  },\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 1.65,\n" +
            "    \"deg\": 281\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 100     \n" +
            "  },\n" +
            "  \"dt\": 1580144397, \n" +
            "  \"sys\": {\n" +
            "    \"country\": \"UA\",\n" +
            "    \"sunrise\": 1580104637,\n" +
            "    \"sunset\": 1580137367\n" +
            "  },\n" +
            "  \"timezone\": 7200,\n" +
            "  \"id\": 691650,    \n" +
            "  \"name\": \"Ternopil\", \n" +
            "  \"cod\": 200\n" +
            "}";

    public static void main(String[] args) throws Exception{
        ObjectMapper om = new ObjectMapper();
        WeatherSampleDto dto = om.readValue(json, WeatherSampleDto.class);
        WeatherSample ws = om.readValue(json, WeatherSample.class);
    }




}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherSampleDto implements Serializable {
    @JsonIgnore
    private Long id;
    @JsonProperty("name")
    private String cityName;
    private float temperature;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private int clouds;
    private int cityId;
    @JsonProperty("dt")
    private int time;

    @JsonProperty("main")
    private void unpackMain(Map<String, String> main) {
        temperature = Float.parseFloat(main.get("temp"));
        feelsLike = Float.parseFloat(main.get("feels_like"));
        pressure = Integer.parseInt(main.get("pressure"));
        humidity = Integer.parseInt(main.get("humidity"));

    }

    @JsonProperty("clouds")
    private void unpackClouds(Map<String, Integer> cloudsObj) {
        clouds = cloudsObj.get("all");
    }

    @JsonProperty("id")
    private void unpackId(Integer idObj) {
        cityId = idObj;
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherSample {
    private Long id;
    private String cityName;
    private float temperature;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private int clouds;
    private int cityId;
    private int time;

}